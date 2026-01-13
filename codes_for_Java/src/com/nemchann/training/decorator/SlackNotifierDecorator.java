package com.nemchann.training.decorator;

public class SlackNotifierDecorator extends NotifierDecorator{

    public SlackNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message) {
        System.out.println("Уведомление в Slack: " + message);
        super.wrappedNotifier.send(message);
    }
}
