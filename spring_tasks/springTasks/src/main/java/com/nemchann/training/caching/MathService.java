package com.nemchann.training.caching;

import org.springframework.stereotype.Service;

@Service
public class MathService implements MathServiceInterface{
    @Override
    @Cacheable
    public int factorial(int n) {
        System.out.println("  🔄 ВЫЧИСЛЯЮ factorial(" + n + ")...");

        if (n < 0) {
            throw new IllegalArgumentException("n должен быть >= 0");
        }
        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
            // Имитация долгого вычисления
            try { Thread.sleep(10); } catch (InterruptedException e) {}
        }
        return result;
    }

    @Override
    @Cacheable(cacheName = "fibonacci")
    public int fibonacci(int n) {
        System.out.println("  🔄 ВЫЧИСЛЯЮ fibonacci(" + n + ")...");

        if (n < 0) {
            throw new IllegalArgumentException("n должен быть >= 0");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Рекурсивное вычисление (имитация сложности)
        try { Thread.sleep(20); } catch (InterruptedException e) {}
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Обычный метод без кэширования
    @Override
    public String greet(String name) {
        return "Привет, " + name + "!";
    }
}
