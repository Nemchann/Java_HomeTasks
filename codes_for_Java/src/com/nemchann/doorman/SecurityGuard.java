package com.nemchann.doorman;

public class SecurityGuard implements SecurityVisitor{
    private String name;

    public SecurityGuard(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean checkUser(StudentPerson student) {
        return (student.getName() != null && !student.getName().isEmpty()) && (student.getNumber() != 0);
    }

    @Override
    public boolean checkUser(Teacher teacher) {
        return (teacher.getName() != null && !teacher.getName().isEmpty()) && ((teacher.getRole() != null && !teacher.getRole().isEmpty()) || (teacher.getNumber() != 0));
    }

    @Override
    public boolean checkUser(Person person) {
        return false;
    }

}
