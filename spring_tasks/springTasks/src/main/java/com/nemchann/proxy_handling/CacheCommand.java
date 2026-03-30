package com.nemchann.proxy_handling;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheCommand implements MethodCommand{
    private final Map<Method, Object> cache = new HashMap<>();

    @Override
    public Object execute(Object target, Method method, Object[] args) throws Throwable {
        // Если результат уже есть в кеше — возвращаем его сразу
        if (cache.containsKey(method)) {
            System.out.println("Взято из кеша!");
            return cache.get(method);
        }

        // Если в кеше нет — выполняем реальный метод
        Object result = method.invoke(target, args);

        // Сохраняем на будущее
        cache.put(method, result);
        return result;
    }
}
