package com.nemchann.corporation_database.database_corporation.repositories;

import com.nemchann.corporation_database.database_corporation.pojo.Department;
import com.nemchann.corporation_database.database_corporation.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
    private final Connection connection;

    // Внедряем бин соединения через конструктор
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
            // Устанавливаем значения вместо знаков вопроса (индексация с 1!)
            preparedStatement.setString(1, department.getName());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Добавлено строк: " + rowsAffected);

        } catch (SQLException e) {
            System.err.println("Ошибка при вставке: " + e.getMessage());
        }
    }
}
