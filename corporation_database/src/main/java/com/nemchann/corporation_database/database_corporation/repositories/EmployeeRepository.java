package com.nemchann.corporation_database.database_corporation.repositories;

import com.nemchann.corporation_database.database_corporation.pojo.Department;
import com.nemchann.corporation_database.database_corporation.pojo.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private final Connection connection;

    // Внедряем бин соединения через конструктор
    public EmployeeRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT id, name, department_id FROM employees";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Employee emp = new Employee();
                emp.setId(resultSet.getLong("id"));
                emp.setName(resultSet.getString("name"));
                emp.setDepartmentId(resultSet.getLong("department_id"));
                employees.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void save(Employee employee){
        String sql = "INSERT INTO employees (name, department_id) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setLong(2, employee.getDepartmentId());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Добавлено строк: " + rowsAffected);

        } catch (SQLException e) {
            System.err.println("Ошибка при вставке: " + e.getMessage());
        }
    }

    public void delete(Employee employee) {
        String sql = "DELETE FROM employees WHERE id=" + employee.getId();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            int deletedRows = preparedStatement.executeUpdate();
            System.out.println("Удалено строк: " + deletedRows);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
