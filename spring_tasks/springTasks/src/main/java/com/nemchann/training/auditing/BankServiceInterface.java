package com.nemchann.training.auditing;

public interface BankServiceInterface {
    void deposit(int amount);
    void withdraw(int amount);
    int getBalance();
}
