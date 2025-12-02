package com.nemchann.storages;

import java.util.List;

public class MaximumFinder {
    public static double maximum(Box<? extends Number>... boxes) {
        if (boxes == null || boxes.length == 0) {
            throw new IllegalArgumentException("Boxes array cannot be null or empty");
        }

        double max = Double.NEGATIVE_INFINITY;
        boolean foundValidValue = false;

        for (Box<? extends Number> box : boxes) {
            if (box != null && !box.isEmpty()) {
                Number number = box.getObj(); // Используем геттер вместо прямого доступа
                if (number != null) {
                    double value = number.doubleValue(); // Безопасное преобразование
                    if (value > max) {
                        max = value;
                        foundValidValue = true;
                    }
                }
            }
        }

        if (!foundValidValue) {
            throw new IllegalArgumentException("No valid numbers found in boxes");
        }

        return max;
    }
}
