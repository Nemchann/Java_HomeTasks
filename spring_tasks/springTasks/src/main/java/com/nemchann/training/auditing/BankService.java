package com.nemchann.training.auditing;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

@Service
@Auditable
public class BankService implements BankServiceInterface{
    private int balance = 0;

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
        balance += amount;
        System.out.println("Внесено: " + amount + ", баланс: " + balance);
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
        balance -= amount;
        System.out.println("Снято: " + amount + ", баланс: " + balance);
    }

    @Override
    public int getBalance() {
        System.out.println("Запрос баланса: " + balance);
        return balance;
    }
}
