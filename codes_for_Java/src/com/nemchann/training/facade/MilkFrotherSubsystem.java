package com.nemchann.training.facade;

public class MilkFrotherSubsystem {
    public void frothMilk(){
        try{
            Thread.sleep(1000);
            System.out.println("Молоко взбито!");
        } catch (InterruptedException e) {
            System.out.println("Молоко не взбито!");
        }
    }
}
