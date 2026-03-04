package com.nemchann.default_value;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class AnnotationProcessor {

    public static void reset(Object...objects){
        for (Object obj : objects){
            if (obj == null) continue;

            Class<?> clazz = obj.getClass();

            boolean classAnnotated = clazz.isAnnotationPresent(Default.class);

            Class<?> currentClass = clazz;

            while (currentClass != null){
                Field[] fields = currentClass.getDeclaredFields();

                for (Field field : fields){

                    if (Modifier.isStatic(field.getModifiers())) continue;

                    if (classAnnotated || field.isAnnotationPresent(Default.class)) {
                        resetField(obj, field);
                    }

                }

                currentClass = currentClass.getSuperclass();
            }
        }
    }

    private static void resetField(Object obj, Field field) {
        try {
            field.setAccessible(true);

            Class<?> type = field.getType();

            if (DefaultValueRegistry.hasDefault(type)) {
                Object val = DefaultValueRegistry.getMyDefault(type);
                field.set(obj, val);
            } else {
                field.set(obj, getJavaDefault(type));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static Object getJavaDefault(Class<?> type) {
        if (!type.isPrimitive()) {
            return null;
        }
        if (type == int.class) return 0;
        if (type == boolean.class) return false;
        if (type == double.class) return 0.0;
        if (type == long.class) return 0L;
        if (type == char.class) return '0';
        return 0;
    }

}
