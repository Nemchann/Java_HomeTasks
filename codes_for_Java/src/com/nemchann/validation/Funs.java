package com.nemchann.validation;

public class Funs {
    public static void checkPositive(User user) {
        if (user.getAccounts() < 0) throw new IllegalArgumentException("Accounts must be positive");
    }
}
