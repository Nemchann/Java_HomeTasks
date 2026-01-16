package com.nemchann.traffic_lights;

public class NightTransitionStrategy implements TransitionStrategy{
    @Override
    public ColorState getNextStateAfterGreen(TrafficLight light) {
        return new YellowState(); // Всегда переходим в желтый
    }

    @Override
    public ColorState getNextStateAfterRed(TrafficLight light) {
        return new YellowState(); // Всегда переходим в желтый
    }

    @Override
    public ColorState getNextStateAfterYellow(TrafficLight light) {
        return new YellowState(); // Всегда остаемся в желтом (мигающий желтый)
    }
}
