package com.nemchann.doorman;

public class StudentPerson implements Person{
    private final String name;
    private final int number;

    public StudentPerson(String name, int number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void accept(SecurityVisitor securityVisitor) {
        securityVisitor.checkUser(this);
    }
}
