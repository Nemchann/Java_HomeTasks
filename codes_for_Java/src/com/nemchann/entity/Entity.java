package com.nemchann.entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Entity {
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.getClass().getSimpleName()).append("{");
        List<Field> allFields = new ArrayList<>();
        Class<?> currentClass = this.getClass();

        while (currentClass != null && currentClass != Object.class){
            Field[] fields = currentClass.getDeclaredFields();
            allFields.addAll(Arrays.asList(fields));
            currentClass = currentClass.getSuperclass();
        }

        for (Field field : allFields) {
            field.setAccessible(true);

            str.append(field.getName()).append("=");
            try {
                Object value = field.get(this);
                str.append(value);
            } catch (IllegalAccessException e) {
                str.append("доступ запрещен");
            }
            str.append(", ");
        }

        if (str.length() > this.getClass().getSimpleName().length() + 1) {
            str.setLength(str.length() - 2);
        }
        str.append("}");
        return str.toString();
    }
}
