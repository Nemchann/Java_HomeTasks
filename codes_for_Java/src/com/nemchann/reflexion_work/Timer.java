package com.nemchann.reflexion_work;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Timer {
    public static void time(Object obj){
        Class<?> clz = obj.getClass();
        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods){
            if (method.isAnnotationPresent(MeasureTime.class)) {
                long t = calculateTime(method, obj);
                System.out.println(t);
            }
        }
    }

    private static long calculateTime(Method method, Object obj){
        long start = System.currentTimeMillis();
        try{
            method.setAccessible(true);
            method.invoke(null, obj);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }
}
