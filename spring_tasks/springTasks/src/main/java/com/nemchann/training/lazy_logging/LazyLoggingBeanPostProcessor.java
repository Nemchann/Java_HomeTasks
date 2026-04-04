package com.nemchann.training.lazy_logging;

import com.nemchann.training.logging_processor.LoggingInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.Arrays;

@Component
public class LazyLoggingBeanPostProcessor implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(LazyLogging.class)) {
            return Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new LazyLoggingInvocationHandler(bean)
            );
        }
        return bean;
    }
}
