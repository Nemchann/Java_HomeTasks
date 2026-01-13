package com.nemchann.training.coffee_shop.factory;

public class Cappuccino extends Coffee {

    public Cappuccino(){
        super("Капучино", 70);
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
