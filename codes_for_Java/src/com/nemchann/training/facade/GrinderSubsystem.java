package com.nemchann.training.facade;

public class GrinderSubsystem {
    public void grindBeans(){
        try{
            Thread.sleep(5000);
            System.out.println("Зерна помолоты!");
        } catch (InterruptedException e) {
            System.out.println("Зерна не помолоты!");
        }
    }
}
