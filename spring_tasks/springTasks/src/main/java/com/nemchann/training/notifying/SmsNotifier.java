package com.nemchann.training.notifying;

import org.springframework.stereotype.Component;

@Component
public class SmsNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("Отправлено SMS: " + message);
    }
}
