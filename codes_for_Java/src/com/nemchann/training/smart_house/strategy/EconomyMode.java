package com.nemchann.training.smart_house.strategy;

public class EconomyMode implements Mode{
    @Override
    public void mode() {
        System.out.println("Светим экономно");
    }
}
