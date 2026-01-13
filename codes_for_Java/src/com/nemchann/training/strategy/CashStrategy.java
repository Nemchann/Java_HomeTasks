package com.nemchann.training.strategy;

public class CashStrategy implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Оплачено наличными " + amount + "руб.");
    }
}
