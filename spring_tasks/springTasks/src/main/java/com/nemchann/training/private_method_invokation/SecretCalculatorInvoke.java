package com.nemchann.training.private_method_invokation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class SecretCalculatorInvoke {
    public static void calculateInvoke(int a, int b, SecretCalculator calculator){
        Class<?> clazz = calculator.getClass();

        List<Field> fields = List.of(clazz.getDeclaredFields());

        for (Field field : fields){
            try{
                if (field.getName().equals("secretMultiplier")){
                    field.setAccessible(true);
                    field.set(calculator, 20);
                }
            }
            catch (IllegalAccessException e){
                System.out.println("Нет доступа");
            }
        }

        List<Method> methods = List.of(clazz.getDeclaredMethods());

        for (Method method : methods){
            System.out.println(method);
        }
        try{
            Method method = clazz.getDeclaredMethod("calculate", int.class, int.class);
            method.setAccessible(true);
            method.invoke(calculator, a, b);
        }
        catch (NoSuchMethodException e){
            System.out.println("Не удалось найти метод");
        } catch (InvocationTargetException e) {
            System.out.println("Не удалось вызвать метод");
        } catch (IllegalAccessException e) {
            System.out.println("Не удалось достучаться до метода");
        }
    }
}
