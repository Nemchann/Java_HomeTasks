package com.nemchann.training.decorator;

public class EmailNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("Отправлено на e-mail: " + message);
    }
}
