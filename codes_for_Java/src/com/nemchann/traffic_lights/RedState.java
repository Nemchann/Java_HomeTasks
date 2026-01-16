package com.nemchann.traffic_lights;

public class RedState extends ColorState{
    @Override
    public void next() {
        light.transitionFromRed();
    }

    @Override
    public String getColorName() {
        return "Красный";
    }
}
