package com.nemchann.training.flexible_configuration;

public class MaxOperation implements Operation{
    @Override
    public int execute(int a, int b) {
        return Math.max(a, b);
    }
}
