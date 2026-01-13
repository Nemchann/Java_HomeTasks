package com.nemchann.training.coffee_shop.factory;

public class CoffeeFactory {
    public static Coffee createCoffee(String type) {
        switch (type.toLowerCase()) {
            case "espresso": return new Espresso();
            case "cappuccino": return new Cappuccino();
            case "latte": return new Latte();
            default: throw new IllegalArgumentException("Неизвестный тип кофе");
        }
    }
}
