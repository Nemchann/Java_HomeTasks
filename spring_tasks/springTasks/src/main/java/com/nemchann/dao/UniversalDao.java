package com.nemchann.dao;

import jakarta.data.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.nio.file.attribute.FileAttribute;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UniversalDao<T> {
    private Class<T> clazz;
    @Autowired
    private Connection connection;

    private Field primaryField = null;

    public List<T> findAll(){
        List<T> objects = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + clazz.getSimpleName());
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return objects;
    }

//    public List<T> findByName(String name){
//        List<T> objects = new ArrayList<>();
//        try{
//            Field field = clazz.getDeclaredField("name");
//            Statement statement = connection.prepareStatement("SELECT * FROM " + clazz.getSimpleName() + "WHERE name = " + name);
//            06150971160351
//        }catch(NoSuchFieldException e){
//
//        }catch (SQLException e){
//
//        }
//        return objects;
//    }
//
//    public T findByID(int id){
//        try{
//            Field field = clazz.getDeclaredField("id");
//            Statement statement = connection.prepareStatement("SELECT * FROM " + clazz.getSimpleName() + "WHERE id = " + id);
//
//        }
//        catch(NoSuchFieldException e){
//
//        }catch (SQLException e){
//
//        }

    //}

    public boolean delete(T obj){
        try{
            Statement statement = connection.createStatement();
            Object id = primaryField.get(obj);

            return statement.executeUpdate("DELETE FROM " + clazz.getSimpleName() + "WHERE id = " + id) > 0;

        }catch (SQLException | IllegalAccessException e){
            throw new RuntimeException();
        }
    }

}


/*

дз

 */
