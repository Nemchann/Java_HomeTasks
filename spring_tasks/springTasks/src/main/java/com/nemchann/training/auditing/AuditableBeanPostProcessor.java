package com.nemchann.training.auditing;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class AuditableBeanPostProcessor implements BeanPostProcessor {

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        boolean hasAuditableAnnotation = bean.getClass().isAnnotationPresent(Auditable.class);

        if (hasAuditableAnnotation){
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(), new AuditableInvocationHandler(bean));
        }
        return bean;
    }
}
