package com.nemchann.campaign;

import org.springframework.context.ApplicationEventPublisher;

public class Stock {
    private final String name;
    private double price;
    private ApplicationEventPublisher eventPublisher;

    public Stock(String name, double price, ApplicationEventPublisher eventPublisher) {
        this.name = name;
        this.price = price;
        this.eventPublisher = eventPublisher;
    }

    public void setPrice(double newPrice) {
        double oldPrice = this.price;
        this.price = newPrice;

        eventPublisher.publishEvent(new StockPriceChangeEvent(this, newPrice));
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }
}
