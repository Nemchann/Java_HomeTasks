package com.nemchann;
import com.nemchann.campaign.Printer;
import com.nemchann.campaign.StockService;
import com.nemchann.feedbacks.Feedback;
import com.nemchann.spring_traffics.TrafficLight;
import com.nemchann.student.Student;
import com.nemchann.student.StudentBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;

public class MainTest {

    public static ApplicationContext applicationContext(){
        return new AnnotationConfigApplicationContext("com.nemchann");
    }

    public static void task9_1_1(){
        ApplicationContext ac = applicationContext();
        Object o = ac.getBean("myHelloWorldBean");
        System.out.println(o);
    }

    public static void task9_1_2(){
        ApplicationContext ac = applicationContext();
        Object obj1 = ac.getBean("randomIntBean");
        Object obj2 = ac.getBean("randomIntBean");
        System.out.println(obj1);
        System.out.println(obj2);
    }

    public static void task9_1_3(){
        ApplicationContext ac = applicationContext();
        Object obj = ac.getBean("dateBean");
        Object obj1 = ac.getBean("dateBean");
        System.out.println(obj);
        System.out.println(obj1);
    }

    public static void task9_1_4(){
        ApplicationContext ac = applicationContext();
        Object obj = ac.getBean("predicateBean");
        System.out.println(obj);
    }

    public static void task9_1_5(){
        ApplicationContext ac = applicationContext();
        Object obj1 = ac.getBean("max");
        System.out.println(obj1);
        Object obj2 = ac.getBean("min");
        System.out.println(obj2);
    }

    public static void task9_2_1(){
        ApplicationContext ac = applicationContext();
        for (int i = 0; i < 10; i++){
            int randomNum = ac.getBean("randomIntBean", int.class);
            System.out.println(randomNum);
        }
    }

    public static void task9_2_2(){
        ApplicationContext ac = applicationContext();
        Object fdb1 = ac.getBean("feedbackGood");
        Object fdb2 = ac.getBean("feedbackNormal");
        Object fdb3 = ac.getBean("feedbackRandom");
        System.out.println(fdb1);
        System.out.println(fdb2);
        System.out.println(fdb3);
    }

    public static void task9_2_3(){
        ApplicationContext ac = applicationContext();
        Feedback best1 = ac.getBean("bestFeedback", Feedback.class);
        System.out.println("Лучший отзыв: " + best1);
    }

    public static void task9_2_4(){
        ApplicationContext ac = applicationContext();
        Student student1 = ac.getBean("firstStudentBean", Student.class);
        Student student2 = ac.getBean("secondStudentBean", Student.class);
        System.out.println(student1);
        System.out.println(student2);
    }

    public static void task9_2_5(){
        ApplicationContext ac = applicationContext();
        StudentBuilder builder = ac.getBean(StudentBuilder.class);
        Student student1 = builder.build("Elena");
        Student student2 = builder.build("Petya", 4, 5, 5, 4, 4, 3, 5, 5);

        System.out.println(student1);
        System.out.println(student2);
    }


    public static void task9_2_7(){
        ApplicationContext ac = applicationContext();
        TrafficLight trafficLight = ac.getBean(TrafficLight.class);
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
    }









    public static void task9_2_8(){
        ApplicationContext ac = applicationContext();
        StockService stockService = ac.getBean(StockService.class);

        stockService.updatePrice("TSLA", 570.0);
        stockService.updatePrice("ORCL", 78.0);

    }
}
