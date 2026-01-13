package com.nemchann.training.strategy;

public class CreditCardStrategy implements PaymentStrategy{
    private final String number;

    public CreditCardStrategy(String number){
        this.number = number;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Оплачено кредитной картой с номером: '" + number + "' " + amount + " руб.");
    }
}
