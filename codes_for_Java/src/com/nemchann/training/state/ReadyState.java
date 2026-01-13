package com.nemchann.training.state;

public class ReadyState extends State{

    public ReadyState(Player player){
        super(player);
    }
    @Override
    public void play() {
        player.startPlayback();
        player.changeState(new PlayingState(player));
    }

    @Override
    public void next() {
        player.nextPlayback();
        player.changeState(new PlayingState(player));
    }

    @Override
    public void pause() {
        System.out.println("❌ Нельзя поставить на паузу, трек еще не начался");
    }

    @Override
    public void prev() {
        player.prevPlayback();
    }
}
