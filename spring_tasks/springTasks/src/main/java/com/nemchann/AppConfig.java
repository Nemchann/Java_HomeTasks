package com.nemchann;

import com.nemchann.campaign.Bot;
import com.nemchann.campaign.Printer;
import com.nemchann.campaign.Stock;
import com.nemchann.feedbacks.Feedback;
import com.nemchann.spring_traffics.TrafficLight;
import com.nemchann.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
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

    @Bean
    public Feedback bestFeedback(List<Feedback> allFeedbacks) {
        return allFeedbacks.stream()
                .max(Comparator.comparingInt(Feedback::getGrade))// Сравнивает отзывы по оценке
                .orElseThrow(() -> new IllegalStateException("Нет доступных отзывов"));
    }

    //Студенты
    @Bean
    @Qualifier("gradePredicate")
    public Predicate<Integer> predicateBean(){
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 2 && integer <= 5;
            }
        };
    }

    @Bean
    public Student firstStudentBean(@Qualifier("predicateBean") Predicate<Integer> gradeValidator){
        return new Student("Vasya", gradeValidator, 3, 5, 2, 4, 5, 4, 3, 3, 3, 5, 5, 5);
    }

    @Bean
    public Student secondStudentBean(@Qualifier("predicateBean") Predicate<Integer> gradeValidator){
        return new Student("Anya", gradeValidator, 5, 5, 4, 4, 4, 5, 5, 5, 3, 3, 5, 4);
    }





    //Акции
    @Bean
    public Set<String> printerStocks() {
        return Set.of("ORCL", "TSLA");
    }

    @Bean
    public String botStock() {
        return "ORCL";
    }

    @Bean
    public Stock orclStock(ApplicationEventPublisher eventPublisher) {
        return new Stock("ORCL", 75.0, eventPublisher);
    }

    @Bean
    public Stock tslaStock(ApplicationEventPublisher eventPublisher) {
        return new Stock("TSLA", 696.0, eventPublisher);
    }


}
