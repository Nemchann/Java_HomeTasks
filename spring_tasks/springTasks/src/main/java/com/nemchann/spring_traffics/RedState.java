package com.nemchann.spring_traffics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("red")
public class RedState extends ColorState{

    @Autowired
    public void setNextState(@Qualifier("yellowAfterRed") ColorState nextState){
        this.nextState = nextState;
    }

    @Override
    public ColorState getNext(){
        return nextState;
    }

    @Override
    public String getColorName() {
        return "red";
    }
}
