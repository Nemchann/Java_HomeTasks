package com.nemchann.doorman;

public interface SecurityVisitor {
    boolean checkUser(StudentPerson student);
    boolean checkUser(Teacher teacher);
    boolean checkUser(Person person);
}
