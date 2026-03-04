package com.nemchann.default_value;

import java.util.HashMap;
import java.util.Map;

public class DefaultValueRegistry {
    private static final Map<Class<?>, Object> defaults = new HashMap<>();

    static {
        defaults.put(String.class, "hello");
        defaults.put(int.class, 42);

        defaults.put(Object.class, new Object());
    }

    public static Object getMyDefault(Class<?> type) {
        return defaults.get(type);
    }

    public static boolean hasDefault(Class<?> type) {
        return defaults.containsKey(type);
    }
}