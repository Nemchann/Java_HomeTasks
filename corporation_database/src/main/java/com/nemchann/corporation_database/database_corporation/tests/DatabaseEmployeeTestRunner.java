package com.nemchann.corporation_database.database_corporation.tests;

import com.nemchann.corporation_database.database_corporation.pojo.Employee;
import com.nemchann.corporation_database.database_corporation.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseEmployeeTestRunner implements CommandLineRunner {
    private final EmployeeRepository repository;

    public DatabaseEmployeeTestRunner(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        Employee employee = new Employee(5L, "Petya", 1L);
        //repository.save(employee);
        //repository.delete(employee);
        System.out.println("Все сотрудники: " + repository.findAll());
    }
}
