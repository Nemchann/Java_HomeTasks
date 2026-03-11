package com.nemchann.validation;


import com.nemchann.mathematic.IntegerWrapper;

@AValidate
public class User {
    private int accounts;

    public User(int accounts){
        this.accounts = accounts;
    }

    public int getAccounts() {
        return accounts;
    }
}