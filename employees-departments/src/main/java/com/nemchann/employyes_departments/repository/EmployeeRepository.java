package com.nemchann.employyes_departments.repository;

import com.nemchann.employyes_departments.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Transactional
    void deleteByName(String name);

    Optional<Employee> findByName(String name);
}
