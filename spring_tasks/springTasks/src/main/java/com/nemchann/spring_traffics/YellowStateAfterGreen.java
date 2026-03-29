package com.nemchann.spring_traffics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("yellowAfterGreen")
public class YellowStateAfterGreen extends ColorState{

    @Autowired
    public void setNextState(@Qualifier("red") ColorState nextState){
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
