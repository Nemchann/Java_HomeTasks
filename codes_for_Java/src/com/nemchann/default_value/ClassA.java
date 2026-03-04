package com.nemchann.default_value;

@Default
public class ClassA {
    String s;
    int x;
    ClassA a;
    Object ob;

    @Override
    public String toString() {
        return "ClassA{" + "s=" + s + ", x=" + x + ", a=" + a + ", ob=" + ob + '}';
    }
}
