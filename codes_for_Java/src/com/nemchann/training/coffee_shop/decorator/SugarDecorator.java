package com.nemchann.training.coffee_shop.decorator;

import com.nemchann.training.coffee_shop.factory.Coffee;

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.decoratedCoffee.getDescription() + " с сахаром";
    }

    @Override
    public int getCost() {
        return super.decoratedCoffee.getCost() + 10;
    }
}
