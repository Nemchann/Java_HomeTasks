package com.nemchann.training.smart_house;

import com.nemchann.training.coffee_shop.CoffeeShopManager;
import com.nemchann.training.smart_house.strategy.Mode;

public class SmartHomeController {
    private static SmartHomeController instance;
    private String name;
    private Mode mode;
    private boolean turnLightsOn;
    private int humidity;


    private SmartHomeController(){
        this.name = "My house";
        this.turnLightsOn = false;
        this.humidity = 70;
    };

    private static class Holder{
        private static final SmartHomeController INSTANCE = new SmartHomeController();
    }

    public static SmartHomeController getInstance(){
        return Holder.INSTANCE;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void executeMode(){
        this.mode.mode();
    }

    public int getHumidity() {
        return humidity;
    }

    public void improveHumidity() {
        this.humidity += 5;
        System.out.println("Данная влажность: " + humidity + "%");
    }

    public void reduceHumidity() {
        this.humidity -= 5;
        System.out.println("Данная влажность: " + humidity + "%");
    }

    public boolean isTurnLightsOn() {
        return turnLightsOn;
    }

    public void turnOn(){
        System.out.println("Свет включен");
        turnLightsOn = true;
    }

    public void turnOff(){
        System.out.println("Свет выключен");
        turnLightsOn = false;
    }
}
