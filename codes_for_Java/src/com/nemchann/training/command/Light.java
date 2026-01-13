package com.nemchann.training.command;

public class Light {
    private boolean isTurnedOn;
    private boolean isColored;

    public Light(){
        this.isTurnedOn = false;
        this.isColored = false;
    }
    void turnOn(){
        isTurnedOn = true;
        System.out.println("Свет включен");
    }

    void turnOff(){
        isTurnedOn = false;
        System.out.println("Свет выключен");
    }

    void stereoOn(){
        isColored = true;
        System.out.println("Дополнительный цвет включен");
    }

    void stereoOff(){
        isColored = false;
        System.out.println("Дополнительный цвет выключен");
    }

}
