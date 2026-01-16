package com.nemchann.doorman;

public class ParentPerson implements Person{
    @Override
    public void accept(SecurityVisitor securityVisitor) {
        securityVisitor.checkUser(this);
    }
}
