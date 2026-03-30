package com.nemchann.training.class_analyzer;

public class Human {
    private String name;
    private int age;

    public Human(String name, int age){
        this.name = name;
        if(age < 0) throw new IllegalArgumentException("age mustn't be negative");
        this.age = age;
    }

    public void older(int extraYears){
        if(extraYears <= 0) throw new IllegalArgumentException("extraYears must be positive");
        this.age += extraYears;
    }

    public String sayHello(){
        return "Привет! Я " + name;
    }
}
