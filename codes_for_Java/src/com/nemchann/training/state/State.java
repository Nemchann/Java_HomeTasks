package com.nemchann.training.state;

public abstract class State {
    protected Player player;

    public State(Player player){
        this.player = player;
    }

    public abstract void play();
    public abstract void pause();
    public abstract void next();
    public abstract void prev();
}
