package com.nemchann.spring_traffics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("yellowAfterRed")
public class YellowStateAfterRed extends ColorState{
    @Autowired
    public void setNextState(@Qualifier("green") ColorState nextState){
        this.nextState = nextState;
    }

    @Override
    public ColorState getNext(){
        return nextState;
    }

    @Override
    public String getColorName() {
        return "yellow";
    }
}
