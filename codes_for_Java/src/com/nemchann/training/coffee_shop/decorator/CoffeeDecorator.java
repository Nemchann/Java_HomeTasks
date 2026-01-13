package com.nemchann.training.coffee_shop.decorator;

import com.nemchann.training.coffee_shop.factory.Coffee;

public abstract class CoffeeDecorator extends Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee){
        super();
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public int getCost() {
        return decoratedCoffee.getCost();
    }
}
