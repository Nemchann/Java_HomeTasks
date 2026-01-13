package com.nemchann.training.state;

public class PlayingState extends State{
    public PlayingState(Player player){
        super(player);
    }
    @Override
    public void play() {
        System.out.println("Уже играет");
    }

    @Override
    public void next() {
        player.nextPlayback();
    }

    @Override
    public void pause() {
        player.pausedPlayback();
        player.changeState(new PausedState(player));
    }

    @Override
    public void prev() {
        player.prevPlayback();
    }
}
