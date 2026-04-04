package com.nemchann.exam;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.Arrays;

@Component
public class TransactionBeanPostProcessor implements BeanPostProcessor {

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        boolean hasTransactionAnnotation = Arrays.stream(bean.getClass().getDeclaredMethods())
                .anyMatch(method -> method.isAnnotationPresent(Transaction.class));

        if (hasTransactionAnnotation){
            System.out.println("Создаем прокси");
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new TransactionHandler(bean));
        }
        return bean;
    }
}
