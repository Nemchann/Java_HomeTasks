package com.nemchann.training.state;

public class Music {
    private final String name;
    private final double duration;

    public Music(String name, double duration){
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return  name +
                ", длительность = " + duration;
    }
}
