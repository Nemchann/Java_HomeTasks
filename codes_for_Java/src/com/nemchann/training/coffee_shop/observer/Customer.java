package com.nemchann.training.coffee_shop.observer;

import com.nemchann.training.coffee_shop.factory.Coffee;

public class Customer implements OrderObserver {
    private final String name;
    public Coffee coffee;

    public Customer(String name){
        this.name = name;
    }

    @Override
    public void update(String orderStatus) {
        System.out.println(name + ": " + orderStatus); // Добавить имя
        if (coffee != null) {
            System.out.println("  Мой " + coffee.getDescription() + " готов!");
        }
    }

    public void setOrder(Coffee coffee){
        this.coffee = coffee;
    }
}
