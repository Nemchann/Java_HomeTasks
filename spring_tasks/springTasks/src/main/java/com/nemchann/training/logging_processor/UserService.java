package com.nemchann.training.logging_processor;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{

    @Override
    @LogExecutionTime
    public void slowMethod(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Долгая загрузка метода");
    }

    @Override
    @LogExecutionTime
    public void fastMethod(){
        System.out.println("Быстрый метод");
    }

    @Override
    public void normalMethod() {
        System.out.println("Обычный метод без логирования");
    }

}
