package com.nemchann.training.coffee_shop.factory;

public class Latte extends Coffee {
    public Latte(){
        super("Латте", 80);
    }
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
