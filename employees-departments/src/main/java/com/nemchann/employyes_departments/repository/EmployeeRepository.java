package com.nemchann.employyes_departments.repository;

import com.nemchann.employyes_departments.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
