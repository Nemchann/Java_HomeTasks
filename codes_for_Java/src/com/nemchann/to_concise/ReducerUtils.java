package com.nemchann.to_concise;

import java.util.List;

public class ReducerUtils {

    public static <T> T reduce(List<T> list, T identity, Reducer<T> reducer) {
        if (list == null || list.isEmpty()) {
            return identity; // Возвращаем начальное значение
        }

        T result = identity;

        for (T element : list) {
            result = reducer.reduce(result, element);
        }

        return result;
    }

}