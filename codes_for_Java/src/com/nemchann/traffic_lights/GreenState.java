package com.nemchann.traffic_lights;

public class GreenState extends ColorState{
    @Override
    public void next() {
        // Логика перехода определена в контексте
        light.transitionFromGreen();
    }

    @Override
    public String getColorName() {
        return "Зеленый";
    }
}
