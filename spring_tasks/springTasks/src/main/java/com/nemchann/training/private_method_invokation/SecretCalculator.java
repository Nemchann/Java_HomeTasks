package com.nemchann.training.private_method_invokation;

public class SecretCalculator {
    private int secretMultiplier = 10;

    private int calculate(int a, int b) {
        System.out.println((a + b) * secretMultiplier);
        return (a + b) * secretMultiplier;
    }

    public void publicMethod() {
        System.out.println("Это публичный метод");
    }
}
