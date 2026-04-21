package com.nemchann.employyes_departments.service;

import com.nemchann.employyes_departments.entity.Department;
import com.nemchann.employyes_departments.entity.Employee;
import com.nemchann.employyes_departments.repository.DepartmentRepository;
import com.nemchann.employyes_departments.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository repository, DepartmentRepository departmentRepository){
        this.repository = repository;
        this.departmentRepository = departmentRepository;
    }

    public void createEmployee(String name, Integer departmentId){
        Employee employee = new Employee();
        if (departmentRepository.existsById(departmentId)){
            employee.setName(name);
            employee.setDepartmentId(departmentId);
        }
        else{
            employee.setName(name);
            System.out.println("Не существует отдела с id:"
                    + departmentId + ". Создан работник без отдела");
        }
        repository.save(employee);
    }

    public Employee findById(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Работник с id:" + id + "не найден"));
    }

    public List<Employee> findAll(){
        return repository.findAll();
    }

    public void delete(Employee employee){
        repository.delete(employee);
    }

}
