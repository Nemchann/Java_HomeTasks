package com.nemchann.training.command;

public class Light {
    private boolean isTurnedOn;
    private String location;

    public Light(String location){
        this.isTurnedOn = false;
        this.location = location;
    }
    public void turnOn(){
        isTurnedOn = true;
        System.out.println("Свет включен");
    }

    public void turnOff(){
        isTurnedOn = false;
        System.out.println("Свет выключен");
    }

    public boolean isOn(){
        return isTurnedOn;
    }


}
