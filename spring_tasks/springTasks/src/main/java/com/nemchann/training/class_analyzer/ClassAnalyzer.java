package com.nemchann.training.class_analyzer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class ClassAnalyzer {
    public static void analyzeClass(String className) {

        try{
            Class<?> clazz = Class.forName(className);
            System.out.println("Полное имя класса: " + clazz.getName());
            System.out.println("Короткое имя класса: " + clazz.getSimpleName());

            List<Field> fields = List.of(clazz.getDeclaredFields());

            System.out.println("Поля: ");
            for (Field field : fields){
                System.out.println("- " + field);
            }

            List<Method> methods = List.of(clazz.getDeclaredMethods());

            System.out.println("Методы: ");
            for (Method method : methods){
                if(Modifier.isPublic(method.getModifiers())){
                    System.out.println("- " + method);
                }
            }
        }
        catch (ClassNotFoundException e){
            System.out.println("Класс не найден");
        }

    }
}
