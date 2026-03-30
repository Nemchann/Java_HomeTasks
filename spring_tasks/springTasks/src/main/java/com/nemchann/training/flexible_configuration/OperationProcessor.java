package com.nemchann.training.flexible_configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
@PropertySource("classpath:application.properties")
public class OperationProcessor {
    @Value("${operation.class}")
    private String operationClassName;

    @PostConstruct
    public void init() {
        System.out.println("operationClassName = " + operationClassName);
    }

    public void process(int a, int b) {
        if (operationClassName == null || operationClassName.isEmpty()) {
            System.err.println("Ошибка: operationClassName не задан в properties!");
            return;
        }
        try{
            Class<?> clazz = Class.forName(operationClassName);
            Operation operation = (Operation) clazz.getDeclaredConstructor().newInstance();
            int result = operation.execute(a, b);
            System.out.println(result);
        } catch (ClassNotFoundException e){
            System.out.println("Класс не найден");
        } catch (InvocationTargetException e) {
            System.out.println("Нельзя вызвать");
        } catch (InstantiationException e) {
            System.out.println("Нельзя сделать объект класса");
        } catch (IllegalAccessException e) {
            System.out.println("Нет доступа");
        } catch (NoSuchMethodException e) {
            System.out.println("Метод не найден");
        }

    }
}
