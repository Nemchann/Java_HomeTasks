package com.nemchann.proxy_handling;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandAnnotationBeanPostProcessor implements BeanPostProcessor {
    // Храним команды временно, пока бин инициализируется
    private final Map<String, List<MethodCommand>> commandsMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        List<MethodCommand> commands = new ArrayList<>();

        // 1. Ищем аннотацию @ToString
        if (beanClass.isAnnotationPresent(ToString.class)) {
            commands.add(new ToStringCommand());
        }

        // 2. Ищем аннотацию @Cache
        if (beanClass.isAnnotationPresent(Cache.class)) {
            commands.add(new CacheCommand());
        }

        // Если нашли аннотации — сохраняем список команд для этого бина
        if (!commands.isEmpty()) {
            commandsMap.put(beanName, commands);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        List<MethodCommand> commands = commandsMap.get(beanName);

        // Если для этого бина были найдены команды — создаем ОДИН прокси
        if (commands != null && !commands.isEmpty()) {
            System.out.println("Создаем единый прокси для бина: " + beanName);

            return Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new CommandInvocationHandler(bean, commands)
            );
        }

        return bean;
    }
}
