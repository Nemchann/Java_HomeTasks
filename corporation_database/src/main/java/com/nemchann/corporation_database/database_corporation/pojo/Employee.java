package com.nemchann.corporation_database.database_corporation.pojo;

public class Employee {
    private Long id;
    private String name;
    private Long departmentId;

    public Employee(){

    }

    public Employee(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Employee(Long id, String name, Long departmentId){
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
