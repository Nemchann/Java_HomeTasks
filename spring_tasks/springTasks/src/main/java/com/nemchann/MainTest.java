package com.nemchann;
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
}
