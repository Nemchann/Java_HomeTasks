package com.nemchann.training.coffee_shop.decorator;

import com.nemchann.training.coffee_shop.factory.Coffee;

public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.decoratedCoffee.getDescription() + " с молоком";
    }

    @Override
    public int getCost() {
        return super.decoratedCoffee.getCost() + 20;
    }
}
