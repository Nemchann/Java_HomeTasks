package com.nemchann.two_parameteres;

public class Processor {
    public static void process(Class<?> clazz){
        if (clazz.isAnnotationPresent(Two.class)) {
            Two annotation = clazz.getAnnotation(Two.class);

            System.out.println("Класс: " + clazz.getSimpleName());
            System.out.println("Параметр first: " + annotation.first());
            System.out.println("Параметр second: " + annotation.second());

            // Логика обработки на основе параметров
            if (annotation.second() > 5) {
                System.out.println(">> Внимание! Высокий приоритет обработки!");
            }
        }
    }
}
