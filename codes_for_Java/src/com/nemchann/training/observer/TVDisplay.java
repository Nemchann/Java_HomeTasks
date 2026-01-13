package com.nemchann.training.observer;

public class TVDisplay implements Observer{
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Вывод на экран ТВ:\nТемпература:  " +  temperature + "\nВлажность: " + humidity);
    }
}
