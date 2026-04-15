package com.nemchann.corporation_database.database_corporation.tests;

import com.nemchann.corporation_database.database_corporation.pojo.Department;
import com.nemchann.corporation_database.database_corporation.repositories.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseDepartmentTestRunner implements CommandLineRunner {
    private final DepartmentRepository repository;

    public DatabaseDepartmentTestRunner(DepartmentRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Department department = new Department(4L, "PR department");
        repository.save(department);
        //repository.delete(department);
        System.out.println("Все отделы: " + repository.findAll());
    }
}
