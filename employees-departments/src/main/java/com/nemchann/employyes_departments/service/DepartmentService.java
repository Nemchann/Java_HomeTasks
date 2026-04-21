package com.nemchann.employyes_departments.service;

import com.nemchann.employyes_departments.entity.Department;
import com.nemchann.employyes_departments.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository){
        this.repository = repository;
    }

    public void createDepartment(String name){
        Department department = new Department(name);
        repository.save(department);
    }

    public Department findById(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Отдел с id:" + id + "не найден"));
    }

    public List<Department> findAll(){
        return repository.findAll();
    }

    public void delete(Department department){
        repository.delete(department);
    }
}
