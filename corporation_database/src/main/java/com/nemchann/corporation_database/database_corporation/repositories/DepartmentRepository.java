package com.nemchann.corporation_database.database_corporation.repositories;

import com.nemchann.corporation_database.database_corporation.pojo.Department;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
    private final Connection connection;

    public DepartmentRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT id, name FROM departments";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getLong("id"));
                department.setName(resultSet.getString("name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public void save(Department department){
        String sql = "INSERT INTO departments (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, department.getName());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Добавлено строк: " + rowsAffected);

        } catch (SQLException e) {
            System.err.println("Ошибка при вставке: " + e.getMessage());
        }
    }

    public void delete(Department department) {
        String sql = "DELETE FROM departments WHERE id=" + department.getId();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            int deletedRows = preparedStatement.executeUpdate();
            System.out.println("Удалено строк: " + deletedRows);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
