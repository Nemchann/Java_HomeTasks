package com.nemchann.training.checking_parameteres;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.Arrays;

// Создает Proxy. Сначала проверяет, если методы, помеченные аннотацией @Check в классе,
// если да, возвращает Proxy, иначе - сам бин, который пришел, в нашем случае AuthService
@Component
public class CheckBeanPostProcess implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        boolean hasCheckAnnotation = Arrays.stream(bean.getClass().getDeclaredMethods())
                .anyMatch(method -> method.isAnnotationPresent(Check.class));

        if (hasCheckAnnotation){
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(), new CheckInvocationHandler(bean));
        }
        return bean;
    }
}
