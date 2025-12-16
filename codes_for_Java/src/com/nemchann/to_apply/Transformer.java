package com.nemchann.to_apply;

import java.util.ArrayList;
import java.util.List;

public class Transformer {

    public static <T, P> List<P> transform(List<T> list, Appliable<T, P> appliable) {
        List<P> result = new ArrayList<>();

        for (T element : list) {
            P transformed = appliable.apply(element); // Применяем метод
            result.add(transformed);
        }

        return result;
    }
}
