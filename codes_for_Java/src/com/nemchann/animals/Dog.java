package com.nemchann.animals;

public class Dog implements Barkable{
    private String name;

    public Dog(String name){
        this.name = name;
    }

    @Override
    public void bark(){
        System.out.println("Гав!");
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return "Собака: " + name;
    }
}
