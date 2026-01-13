package com.nemchann.training.coffee_shop;

import com.nemchann.training.coffee_shop.factory.Coffee;
import com.nemchann.training.coffee_shop.observer.Customer;
import com.nemchann.training.coffee_shop.observer.OrderObserver;
import com.nemchann.training.coffee_shop.strategy.CoffeePaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShopManager {
    private static CoffeeShopManager instance;
    private String name;
    private CoffeePaymentStrategy coffeePaymentStrategy;
    private List<OrderObserver> observers = new ArrayList<>(); //Попробовать сделать HashMap

    private CoffeeShopManager(){
        this.name = "Coding coffee shop";
    }

    private static class Holder{
        private static final CoffeeShopManager INSTANCE = new CoffeeShopManager();
    }

    public static CoffeeShopManager getInstance(){
        return Holder.INSTANCE;
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Coffee coffee, Customer customer) {
        System.out.println("Принят заказ: " + coffee.getDescription());
        customer.setOrder(coffee);
        registerObserver(customer);
        processPayment(coffee.getCost());
        prepareOrder(customer);
    }

    public void setPaymentStrategy(CoffeePaymentStrategy coffeePaymentStrategy){
        this.coffeePaymentStrategy = coffeePaymentStrategy;
    }

    private void processPayment(int value){
        if (coffeePaymentStrategy == null){
            throw new IllegalArgumentException("Не указан тип оплаты");
        }
        this.coffeePaymentStrategy.pay(value);
    }

    private void prepareOrder(Customer customer) {
        // Имитация приготовления
        try {
            Thread.sleep(2000);
            notifyObservers(customer, "Ваш заказ готов!");
        } catch (InterruptedException e) {
            notifyObservers(customer, "Ваш заказ не готов!");
        }
    }

    public void registerObserver(OrderObserver o){
        observers.add(o);
    }

    public void removeObserver(OrderObserver o){
        observers.remove(o);
    }

    private void notifyObservers(Customer customer, String message){
        for (OrderObserver o : observers){
            o.update(message);
        }
        customer.update(message);
    }
}
