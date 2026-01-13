package com.nemchann.training.facade;

public class BrewerSubsystem {
    public void brew(){
        try{
            Thread.sleep(2000);
            System.out.println("Кофе заварен!");
        } catch (InterruptedException e) {
            System.out.println("Кофе не заварен!");
        }

    }
}
