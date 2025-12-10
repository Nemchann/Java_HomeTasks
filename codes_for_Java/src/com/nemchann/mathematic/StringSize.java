package com.nemchann.mathematic;

public class StringSize implements Numeric{
    final String string;

    public StringSize(String string){
        this.string = string;
    }

    @Override
    public double toDouble() {
        return string.length();
    }
}
