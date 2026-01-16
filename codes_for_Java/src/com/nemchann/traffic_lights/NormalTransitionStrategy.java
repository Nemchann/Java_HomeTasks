package com.nemchann.traffic_lights;

public class NormalTransitionStrategy implements TransitionStrategy{
    @Override
    public ColorState getNextStateAfterGreen(TrafficLight light) {
        return new YellowState();
    }

    @Override
    public ColorState getNextStateAfterRed(TrafficLight light) {
        return new YellowState();
    }

    @Override
    public ColorState getNextStateAfterYellow(TrafficLight light) {
        // Определяем, из какого состояния пришли в желтый
        // В реальной реализации нужно хранить историю
        ColorState current = light.getCurrentState();
        if (current instanceof YellowState) {
            // Простая логика: чередуем красный и зеленый
            // В реальном приложении нужно отслеживать предыдущее состояние
            return Math.random() > 0.5 ? new RedState() : new GreenState();
        }
        return new RedState(); // fallback
    }
}
