package com.nemchann.training.observer;

public class PhoneDisplay implements Observer{
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Вывод на экран Смартфона:\nТемпература:  " +  temperature + "\nВлажность: " + humidity);
    }
}
