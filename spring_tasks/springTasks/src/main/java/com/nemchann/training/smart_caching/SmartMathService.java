package com.nemchann.training.smart_caching;

import com.nemchann.training.caching.MathServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartMathService implements SmartMathServiceInterface {
    @Autowired
    private SmartMathServiceInterface self;

    @SmartCacheable
    public long factorial(int n) {
        System.out.println("Вычисляю factorial(" + n + ")...");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
            try {
                Thread.sleep(50); // имитация долгой операции
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return result;
    }

    @SmartCacheable
    public long fibonacci(int n) {
        System.out.println("Вычисляю fibonacci(" + n + ")...");
        if (n <= 1) return n;
        // вызываем через прокси, чтобы сработал кэш
        return self.fibonacci(n - 1) + self.fibonacci(n - 2);
    }

}
