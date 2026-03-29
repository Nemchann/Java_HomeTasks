package com.nemchann.spring_traffics;


public abstract class ColorState {
    ColorState nextState;

    public abstract String getColorName();

    public abstract ColorState getNext();

}
