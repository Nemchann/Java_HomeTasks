package com.nemchann;

import com.nemchann.feedbacks.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.*;
import java.util.function.Predicate;


@Configuration
public class AppConfig {
    private List<Integer> availableNumbers = new ArrayList<>();

    @Bean
    public String  myHelloWorldBean() {
        return "Hello world";
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

    //Рандом, мин, макс
    @Bean
    @Scope("prototype")
    public Integer randomIntBean(@Qualifier("min") Integer min, @Qualifier("max") Integer max){
        if (availableNumbers.isEmpty()) {

            for (int i = min; i <= max; i++) {
                availableNumbers.add(i);
            }

            Collections.shuffle(availableNumbers);

        }
        return availableNumbers.removeFirst();
    }

    @Bean
    public Integer min(){
        return 1;
    }

    @Bean
    public Integer max(){
        return 10;
    }

    //Отзывы
    @Bean
    public Feedback feedbackGood(){
        return new Feedback(4, "Очень хорошо");
    }

    @Bean
    public Feedback feedbackNormal(){
        return new Feedback(3, "Сойдет");
    }

    @Bean
    public Feedback feedbackRandom(@Qualifier("randomIntBean") Integer randomIntBean){
        return new Feedback(randomIntBean, "Сложно сказать");
    }

//    @Bean
//    public Feedback feedbackBest(@Qualifier("feedbackGood") Feedback feedbackGood, @Qualifier("feedbackNormal") Feedback feedbackNormal,
//                                 @Qualifier("feedbackRandom") Feedback feedbackRandom){
//
//
//    }
//
//    private Feedback maxGrade(Feedback fdb1, Feedback fdb2, Feedback fdb3){
//
//    }
}
