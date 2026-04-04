package com.nemchann.training;

import com.nemchann.training.smart_caching.SmartMathService;
import com.nemchann.training.spring_configuration.GreetingController;
import com.nemchann.training.spring_configuration.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.nemchann")
public class TrainingConfig {

//    @Bean
//    public GreetingService greetingService(){
//        return new GreetingService();
//    }
//
//    @Bean
//    public GreetingController greetingController(GreetingService service){
//        return new GreetingController(service);
//    }
}
