package com.nemchann.training.coffee_shop.factory;

public class Espresso extends Coffee {
    public Espresso(){
        super("Эспрессо", 50);
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
