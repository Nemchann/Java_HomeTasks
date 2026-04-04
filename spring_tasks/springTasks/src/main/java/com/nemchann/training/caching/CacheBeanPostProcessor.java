package com.nemchann.training.caching;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.Arrays;

@Component
public class CacheBeanPostProcessor implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        boolean hasCacheableMethods = Arrays.stream(bean.getClass().getDeclaredMethods())
                .anyMatch(method -> method.isAnnotationPresent(Cacheable.class));

        CacheService service = CacheService.instance();

        if (hasCacheableMethods){

            return Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(), new CacheInvocationHandler(bean, service));
        }
        return bean;
    }

}
