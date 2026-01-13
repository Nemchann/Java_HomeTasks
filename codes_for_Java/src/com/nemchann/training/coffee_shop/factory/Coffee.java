package com.nemchann.training.coffee_shop.factory;

public abstract class Coffee {
    protected String description;
    protected int cost;

    public Coffee(){

    }
    public Coffee(String description, int cost){
        this.description = description;
        this.cost = cost;
    }
    public abstract String getDescription();
    public abstract int getCost();
}
