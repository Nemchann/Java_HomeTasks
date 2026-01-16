package com.nemchann.traffic_lights;

public abstract class ColorState {
    protected TrafficLight light;

    public abstract void next();
    public abstract String getColorName();

    public void setLight(TrafficLight light){
        this.light = light;
    }

}
