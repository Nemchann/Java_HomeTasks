package com.nemchann.corporation_database.database_corporation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class UniversalDao<T> {
    private final Class<T> clazz;
    @Autowired
    private Connection connection;

    private Field primaryField = null;

    public UniversalDao(Class<T> clazz){
        this.clazz = clazz;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                field.setAccessible(true);
                this.primaryField = field;
                break;
            }
        }
    }

    //Старый метод
    public List<T> findAll(){
        String tableName = clazz.getSimpleName();
        List<T> objects = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
            while(resultSet.next()){
                objects.add(convert(resultSet));
            }
        }
        catch (Exception e){
            throw new RuntimeException();
        }
        return objects;
    }

    //Новые методы
    public Stream<T> findAllStream(int limit, int offset) {
        return findAll(limit, offset).stream();
    }

    public List<T> findAll(int limit, int offset) {
        List<T> objects = new ArrayList<>();

        String sql = String.format("SELECT * FROM %s LIMIT %d OFFSET %d",
                clazz.getSimpleName(), limit, offset);
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                objects.add(convert(resultSet));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

    public int insert(T obj){
        try{
            Statement statement = connection.createStatement();
            Object id = primaryField.get(obj);
            Field[] fields = clazz.getDeclaredFields();


            return statement.executeUpdate("INSERT INTO " + clazz.getSimpleName() + " VALUES " + convertFields(obj));

        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean delete(T obj){
        try{
            Statement statement = connection.createStatement();
            Object id = primaryField.get(obj);

            return statement.executeUpdate("DELETE FROM " + clazz.getSimpleName() + " WHERE id = " + id) > 0;

        }catch (SQLException | IllegalAccessException e){
            throw new RuntimeException();
        }
    }

    private T convert (ResultSet set) throws Exception{
        T obj = clazz.getConstructor().newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            field.setAccessible(true);
            String fieldName = field.getName();
            field.set(obj, set.getObject(fieldName));
        }

        return obj;
    }

    private String convertFields(T obj) {
        String result = "(";
        Field[] fields = clazz.getDeclaredFields();
        try{
            for (Field field : fields){
                Object fieldValue = field.get(obj);
                if (fieldValue instanceof String){
                    result += "'" + fieldValue + "', ";
                }
                result += fieldValue.toString() + ", ";
            }
        }catch (IllegalAccessException e){
            throw new RuntimeException();
        }
        String fullResult = result.substring(0, result.length() - 2); // Убираем последние запятую и пробел

        fullResult += ")";
        return fullResult;
    }


}
