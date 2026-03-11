package com.nemchann;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        System.out.println(obj);
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
}
