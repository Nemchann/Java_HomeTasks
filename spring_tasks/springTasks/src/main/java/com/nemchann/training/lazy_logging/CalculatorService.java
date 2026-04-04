package com.nemchann.training.lazy_logging;

import org.springframework.stereotype.Service;

@LazyLogging
@Service
public class CalculatorService implements CalculatorServiceInterface{
    private boolean silent = false;

    @Override
    public void silentMode() {
        this.silent = true;
        System.out.println("Тихий режим ВКЛЮЧЕН");
    }

    @Override
    public void normalMode() {
        this.silent = false;
        System.out.println("Тихий режим ВЫКЛЮЧЕН");
    }

    @Override
    public int add(int a, int b) {
        int result = a + b;
        if (!silent) {
            System.out.println("[LOG] Сложение: " + a + " + " + b + " = " + result);
        }
        return result;
    }

    @Override
    public int subtract(int a, int b) {
        int result = a - b;
        if (!silent) {
            System.out.println("[LOG] Вычитание: " + a + " - " + b + " = " + result);
        }
        return result;
    }
}
