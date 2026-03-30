package com.nemchann.training.notifying;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationService {
    private List<Notifier> notifiers;

    public NotificationService(List<Notifier> notifiers){
        this.notifiers = notifiers;
    }

    public void notifyAll(String message){
        for (Notifier notifier : notifiers){
            notifier.send(message);
        }
    }


}
