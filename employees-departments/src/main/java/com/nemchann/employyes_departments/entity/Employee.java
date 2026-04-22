package com.nemchann.employyes_departments.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "department_id")
    private Integer departmentId;

    public Employee(){

    }

    public Employee(String name){
        this.name = name;
    }

    public Employee(String name, Integer departmentId){
        this.name = name;
        this.departmentId = departmentId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
