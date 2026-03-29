package com.nemchann.traffic_lights;

public class TrafficLight {
    private ColorState state;
    private TransitionStrategy transitionStrategy;

    public TrafficLight(){
        this.state = new YellowState();
        this.state.setLight(this);
        this.transitionStrategy = new NormalTransitionStrategy();
    }

    public void next(){
        state.setLight(this);
        System.out.println(state.getColorName());
        state.next();
    }

    void transitionFromGreen() {
        changeState(transitionStrategy.getNextStateAfterGreen(this));
    }

    void transitionFromRed() {
        changeState(transitionStrategy.getNextStateAfterRed(this));
    }

    void transitionFromYellow() {
        changeState(transitionStrategy.getNextStateAfterYellow(this));
    }

    void changeState(ColorState state){
        this.state = state;
        this.state.setLight(this);
    }

    // Метод для установки стратегии
    public void setTransitionStrategy(TransitionStrategy strategy) {
        this.transitionStrategy = strategy;
    }

    ColorState getCurrentState() {
        return state;
    }

}
