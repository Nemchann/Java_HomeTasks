package com.nemchann.geometry;

public class StringSizing implements Sizeable{
    private final String string;

    public StringSizing(String string){
        this.string = string;
    }

    @Override
    public double getSize() {
        return string.length();
    }
}
