package com.nemchann.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Validator {
    public static void validate(Object... objects) {

        for (Object object : objects){
            if (object == null) continue;

            checkObject(object);
        }
//        Method[] methods = testClass.getDeclaredMethods();
//
//        for (Method method : methods){
//            if (Modifier.isPublic(method.getModifiers()) &&
//            Modifier.isStatic(method.getModifiers()) &&
//            method.getParameterCount() == 1){
//
//                Class<?> paramType = method.getParameterTypes()[0];
//                if (paramType.isAssignableFrom(object.getClass())) {
//                    try {
//                        method.setAccessible(true);
//
//                        method.invoke(null, object); //null - методы статические
//
//                    } catch (Exception e) {
//                        String errorMessage = String.format(
//                                "ошибка в %s: %s",
//                                method.getName(),
//                                e.getCause() != null ? e.getCause().getMessage() : "неизвестная ошибка"
//                        );
//                        throw new ValidateException(errorMessage);
//                    }
//                }
//            }
//        }
    }

    private static void checkObject(Object object){
        Class<?> objectClass = object.getClass();


        if (objectClass.isAnnotationPresent(Validate.class)) {
            Validate directAnnotation = objectClass.getAnnotation(Validate.class);
            runTests(object, directAnnotation.value());
        }

        Annotation[] annotations = objectClass.getAnnotations();

        for (Annotation annotation : annotations) {
            Class<? extends Annotation> annotationType = annotation.annotationType();

            if (annotationType.isAnnotationPresent(Validate.class)) {
                Validate metaAnnotation = annotationType.getAnnotation(Validate.class);
                runTests(object, metaAnnotation.value());
            }
        }

    }

    private static void runTests(Object object, Class<?>[] testClasses){
        for (Class<?> testClass : testClasses) {
            Method[] methods = testClass.getDeclaredMethods();

            for (Method method : methods) {
                if (isTestMethod(method)) {

                    Class<?> paramType = method.getParameterTypes()[0];
                    if (paramType.isAssignableFrom(object.getClass())) {
                        try {
                            method.setAccessible(true);
                            method.invoke(null, object);
                        } catch (InvocationTargetException e) {
                            Throwable cause = e.getCause();
                            String errorMessage = String.format(
                                    "ошибка в %s: %s",
                                    method.getName(),
                                    cause != null ? cause.getMessage() : "неизвестная ошибка"
                            );
                            throw new ValidateException(errorMessage);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    private static boolean isTestMethod(Method method){
        return Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())
                && method.getParameterCount() == 1;
    }
}
