package com.nemchann.mathematic;

public class Calculator {
    public static double sum(Numeric... values) {
        double result = 0.0;
        for (Numeric value : values) {
            result += value.toDouble();
        }
        return result;
    }
}
