package com.nemchann.spring_traffics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class    TrafficLight {
    ColorState state;

    @Autowired
    public TrafficLight(@Qualifier("green") ColorState initialState) {
        this.state = initialState;
    }

    public void next(){
        System.out.println(state.getColorName());
        this.state = state.getNext();
    }

    public ColorState getState(){
        return state;
    }
}
