package com.nemchann.mathematic;

import java.util.HashMap;
import java.util.Map;
public class FractionGenerator {
    private static FractionGenerator instance;
    private final Map<String, Fraction> fractionCache = new HashMap<>();

    private FractionGenerator(){

    }
    public static FractionGenerator getInstance(){
        if (instance == null) {
            instance = new FractionGenerator();
        }
        return instance;
    }
//    public Fraction createFraction(int numerator, int denominator){
//        return new Fraction(numerator, denominator);
//    }

    public Fraction getFraction(int numerator, int denominator) {
        // Приводим к каноническому виду
        int gcd = greatestCommonDivisor(Math.abs(numerator), Math.abs(denominator));
        int simplifiedNum = numerator / gcd;
        int simplifiedDen = denominator / gcd;

        // Нормализуем знак
        if (simplifiedDen < 0) {
            simplifiedNum = -simplifiedNum;
            simplifiedDen = -simplifiedDen;
        }

        // Создаем ключ для кэша
        String key = simplifiedNum + "/" + simplifiedDen;

        // Проверяем кэш
        Fraction cached = fractionCache.get(key);

        if (cached == null) {
            // Создаем новую дробь и кэшируем
            cached = new Fraction(simplifiedNum, simplifiedDen);
            fractionCache.put(key, cached);
        }

        return cached;
    }


    // Вспомогательный метод НОД
    private int greatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return greatestCommonDivisor(b, a % b);
    }

}
