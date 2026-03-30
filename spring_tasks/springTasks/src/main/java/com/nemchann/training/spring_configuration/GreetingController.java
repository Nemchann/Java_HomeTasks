package com.nemchann.training.spring_configuration;

public class GreetingController {
    private GreetingService service;

    public GreetingController(GreetingService service){
        this.service = service;
    }

    public void printGreeting(String name){
        System.out.println(service.greet(name));
    }
}
