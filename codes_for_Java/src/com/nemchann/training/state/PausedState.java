package com.nemchann.training.state;

public class PausedState extends State{
    public PausedState(Player player){
        super(player);
    }

    @Override
    public void play() {
        player.playPlayback();
        player.changeState(new PlayingState(player));
    }

    @Override
    public void next() {
        player.nextPlayback();
    }

    @Override
    public void pause() {
        System.out.println("Уже на паузе");
    }

    @Override
    public void prev() {
        player.prevPlayback();
    }
}
