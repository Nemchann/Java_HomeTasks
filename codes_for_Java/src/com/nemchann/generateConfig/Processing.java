package com.nemchann.generateConfig;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class Processing {
    public static Map<String, Object> process(Class<?> clz)  {
        Map<String, Object> map = new HashMap<>();
        Method[] methods = clz.getDeclaredMethods();

        for (Method method : methods){
            if (Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())
                    && method.getParameterCount() == 0 && method.getReturnType() != void.class){
                try{
                    method.setAccessible(true);

                    Object createdObject = method.invoke(null);

                    map.put(method.getName(), createdObject);

                    System.out.println("Создан объект: " + createdObject +
                            " методом: " + method.getName());
                }
                catch (IllegalAccessException e){
                    throw new IllegalArgumentException("Нет доступа к методу " + method.getName());
                }
                catch (InvocationTargetException e){
                    throw new IllegalArgumentException("Ошибка при исполнении метода " + method.getName());
                }
            }
        }
        return map;
    }
}
