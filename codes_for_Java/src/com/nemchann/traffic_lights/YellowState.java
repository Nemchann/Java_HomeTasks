package com.nemchann.traffic_lights;

public class YellowState extends ColorState{
    @Override
    public void next() {
        light.transitionFromYellow();
    }

    @Override
    public String getColorName() {
        return "Желтый";
    }
}
