package com.nemchann.validation;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Validator {
    public static void validate(Object object, Class<?> testClass) {
        Method[] methods = testClass.getDeclaredMethods();

        for (Method method : methods){
            if (Modifier.isPublic(method.getModifiers()) &&
            Modifier.isStatic(method.getModifiers()) &&
            method.getParameterCount() == 1){

                Class<?> paramType = method.getParameterTypes()[0];
                if (paramType.isAssignableFrom(object.getClass())) {
                    try {
                        method.setAccessible(true);

                        method.invoke(null, object); //null - методы статические

                    } catch (Exception e) {
                        String errorMessage = String.format(
                                "ошибка в %s: %s",
                                method.getName(),
                                e.getCause() != null ? e.getCause().getMessage() : "неизвестная ошибка"
                        );
                        throw new ValidateException(errorMessage);
                    }
                }
            }
        }
    }
}
