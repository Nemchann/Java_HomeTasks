package com.nemchann.training;

import com.nemchann.training.spring_configuration.GreetingController;
import com.nemchann.training.spring_configuration.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrainingConfig {

    @Bean
    public GreetingService greetingService(){
        return new GreetingService();
    }

    @Bean
    public GreetingController greetingController(GreetingService service){
        return new GreetingController(service);
    }
}
