package com.nemchann.training.state;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private State state;
    private List<Music> melodies = new ArrayList<>();
    private int current;

    public Player(List<Music> melodies){
        this.melodies = melodies;
        this.state = new ReadyState(this);
        this.current = 0;
    }

    public void changeState(State state){
        this.state = state;
    }

    public void play() {
        state.play();
    }

    public void pause() {
        state.pause();
    }

    public void next() {
        state.next();
    }

    public void prev() {
        state.prev();
    }

    void startPlayback(){
        current = 0;
        System.out.println(melodies.get(0));
    }

    void playPlayback(){
        System.out.println(melodies.get(current));
    }

    void nextPlayback(){
        if (current == melodies.size()){
            current = 0;
        }
        current++;
    }

    void prevPlayback(){
        if (current == 0){
            System.out.println("Нет предыдущих мелодий");
        }
        else{
            current--;
        }
    }

    void pausedPlayback(){
        System.out.println(melodies.get(current) + " на паузе");
    }
}
