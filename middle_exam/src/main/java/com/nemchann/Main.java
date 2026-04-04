package com.nemchann;


/*
Разработать аннотацию Transaction вешается на метод, если помечен, и принимает лист или мапа

если закончил нормально, то ок, иначе возвращается к предыдущему состоянию
 */

import com.nemchann.exam.MyServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static void main(){
        ApplicationContext context = new AnnotationConfigApplicationContext("com.nemchann.exam");

        MyServiceInterface service = context.getBean(MyServiceInterface.class);

        List<Integer> list = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> list2 = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));

        Map<String, Integer> map = new HashMap<>();

        map.put("rrr", 30);

        service.removeHelloString(map);
        service.removeTenthIndex(list2);
        for (int i = 0; i < list2.toArray().length; i++){
            System.out.println(list2.get(i));
        }
        service.removeTenthIndex(list);
    }
}
