package com.nemchann.training.smart_caching;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import com.nemchann.training.smart_caching.SmartCacheable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class CachingAspect {
    private final Map<String, Object> cache = new HashMap<>();

    @Around("@annotation(SmartCacheable)")
    public Object cacheMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = generateKey(joinPoint);

        if (cache.containsKey(key)) {
            System.out.println("Кэш: возвращаю сохраненный результат");
            return cache.get(key);
        }

        Object result = joinPoint.proceed();
        cache.put(key, result);
        return result;
    }

    private String generateKey(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        String args = Arrays.toString(joinPoint.getArgs());
        return methodName + args;
    }
}
