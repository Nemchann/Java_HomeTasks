package com.nemchann.doorman;

public class Teacher implements Person{
    private final String name;
    private final String role;
    private final int number;

    public Teacher(String name, String role, int number){
        this.name = name;
        this.role = role;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void accept(SecurityVisitor securityVisitor) {
        securityVisitor.checkUser(this);
    }
}
