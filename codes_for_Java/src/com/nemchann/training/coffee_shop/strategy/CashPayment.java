package com.nemchann.training.coffee_shop.strategy;

public class CashPayment implements CoffeePaymentStrategy {

    @Override
    public void pay(int value) {
        System.out.println("Оплачено наличными " + value + " руб.");
    }
}
