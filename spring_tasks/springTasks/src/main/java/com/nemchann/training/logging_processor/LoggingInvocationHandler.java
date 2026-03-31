package com.nemchann.training.logging_processor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingInvocationHandler implements InvocationHandler {
    private final Object bean;

    public LoggingInvocationHandler(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method targetMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());

        if (targetMethod.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.currentTimeMillis();

            Object result = method.invoke(bean, args);

            long endTime = System.currentTimeMillis();

            System.out.println("Метод выполнен за столько " + (endTime - startTime) + " миллисекунд");

            return result;
        }

        return method.invoke(bean, args);

    }
}