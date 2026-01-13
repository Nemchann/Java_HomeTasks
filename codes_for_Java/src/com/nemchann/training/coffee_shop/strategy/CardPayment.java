package com.nemchann.training.coffee_shop.strategy;

public class CardPayment implements CoffeePaymentStrategy {
    private String number;

    public CardPayment(String number){
        this.number = number;
    }

    @Override
    public void pay(int value) {
        System.out.println("Оплачено картой " + value + " руб.");
    }
}
