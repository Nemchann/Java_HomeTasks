package com.nemchann;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.Random;
import java.util.function.Predicate;


@Configuration
public class AppConfig {

    @Bean
    public String  myHelloWorldBean() {
        return "Hello world";
    }

    @Bean
    @Scope("prototype")
    public int randomIntBean(){
        Random random = new Random();
        return random.nextInt(0, 100);
    }

    @Bean
    @Lazy
    public Date dateBean(){
        return new Date();
    }

    @Bean
    public Predicate<Integer> predicateBean(){
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 2 && integer <= 5;
            }
        };
    }

    @Bean
    public int min(){
        return 1;
    }

    @Bean
    public int max(){
        return 10;
    }
}
