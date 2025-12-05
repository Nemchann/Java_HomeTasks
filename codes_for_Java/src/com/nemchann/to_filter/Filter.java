package com.nemchann.to_filter;

import com.nemchann.to_apply.Appliable;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static <T> List<T> testing(List<T> list, Testable<T> testable){
        List<T> result = new ArrayList<>();

        for (T element : list) {
            boolean transformed = testable.test(element);
            if (transformed) result.add(element);
        }

        return result;
    }
}
