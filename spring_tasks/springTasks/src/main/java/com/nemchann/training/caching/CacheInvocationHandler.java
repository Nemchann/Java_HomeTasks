package com.nemchann.training.caching;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CacheInvocationHandler implements InvocationHandler {
    private Object target;
    private final CacheService cacheService;

    public CacheInvocationHandler(Object target, CacheService cacheService){
        this.cacheService = cacheService;
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass() == Object.class){
            return method.invoke(target, args);
        }

        Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

        if (targetMethod.isAnnotationPresent(Cacheable.class)){
            Cacheable cacheable = targetMethod.getAnnotation(Cacheable.class);
            String cacheName = cacheable.cacheName();
            String key = generateKey(method.getName(), args);

            Object cached = cacheService.get(cacheName, key);
            if(cached != null){
                System.out.println("Извлечено из кеша " + cacheName + "[" + key + "] = " + cached);
            }

            Object result = method.invoke(target, args);

            cacheService.put(cacheName, key, result);
        }

        return method.invoke(target, args);
    }

    private String generateKey(String methodName, Object[] args) {
        return methodName + "(" + Arrays.toString(args) + ")";
    }
}
