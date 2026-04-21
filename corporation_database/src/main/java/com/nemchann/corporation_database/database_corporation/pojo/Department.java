package com.nemchann.corporation_database.database_corporation.pojo;

import com.nemchann.corporation_database.database_corporation.dao.PrimaryKey;

public class Department {
    @PrimaryKey
    private Long id;
    private String name;

    public Department(){

    }

    public Department(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
