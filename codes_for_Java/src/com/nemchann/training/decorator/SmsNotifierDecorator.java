package com.nemchann.training.decorator;

public class SmsNotifierDecorator extends NotifierDecorator{

    public SmsNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message) {
        System.out.println("Уведомление в SMS: " + message);
        super.wrappedNotifier.send(message);
    }
}
