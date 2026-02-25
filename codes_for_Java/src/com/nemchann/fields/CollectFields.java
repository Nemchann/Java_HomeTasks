package com.nemchann.fields;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectFields {
    public static List<Field> fieldCollection(Class<?> clz){
        Class<?> clazz = clz;
        List<Field> fields = new ArrayList<>();
        while (clazz != null){
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
}
