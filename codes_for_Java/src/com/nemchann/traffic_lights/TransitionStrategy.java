package com.nemchann.traffic_lights;

public interface TransitionStrategy {
    ColorState getNextStateAfterGreen(TrafficLight light);
    ColorState getNextStateAfterRed(TrafficLight light);
    ColorState getNextStateAfterYellow(TrafficLight light);
}
