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

            //Если аннотация на поле
            if (field.isAnnotationPresent(ToString.class)){
                ToString fieldAnnotation = field.getAnnotation(ToString.class);

                if (fieldAnnotation.value() == Option.NO) continue;
            }
            else{
                Class<?> declaringClass = field.getDeclaringClass();
                //Ищем аннотацию на самом классе
                if (declaringClass.isAnnotationPresent(ToString.class)){
                    ToString classAnnotation = declaringClass.getAnnotation(ToString.class);

                    if (classAnnotation.value() == Option.NO){
                        continue;
                    }
                }
            }

            str.append(field.getName()).append("=");
            try {
                Object value = field.get(this);
                str.append(value);
            } catch (IllegalAccessException e) {
                str.append("N/A");
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
