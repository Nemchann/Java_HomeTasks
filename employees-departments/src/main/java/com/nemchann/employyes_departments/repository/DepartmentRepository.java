package com.nemchann.employyes_departments.repository;

import com.nemchann.employyes_departments.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
