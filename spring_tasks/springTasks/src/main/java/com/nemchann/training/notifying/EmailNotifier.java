package com.nemchann.training.notifying;

import org.springframework.stereotype.Component;

@Component
public class EmailNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("Отправлено Email: " + message);
    }
}
