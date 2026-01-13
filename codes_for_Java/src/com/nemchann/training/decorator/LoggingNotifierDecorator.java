package com.nemchann.training.decorator;

import java.time.LocalDateTime;

public class LoggingNotifierDecorator extends NotifierDecorator{

    public LoggingNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message) {
        System.out.println("[LOG] Отправка уведомления: " + message);
        System.out.println("[LOG] Время: " + LocalDateTime.now());
        wrappedNotifier.send(message);
    }
}
