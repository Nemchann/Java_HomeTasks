package com.nemchann.training.checking_parameteres;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Этот класс обрабатывает бин с этими аннотациями
// И создаем экземпляр класса, когда делаем Proxy
public class CheckInvocationHandler implements InvocationHandler {
    Object target; // Тот самый бин, который мы будем апроксировать

    public CheckInvocationHandler(Object target) {
        this.target = target;
    }


    // Вызываем метод. Если есть аннотация, добавляем функциональность и вызываем метод, если нет - просто вызываем метод
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(target, args);
        }

        //Тот самый метод, который мы будем вызывать
        Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

        // Проверяем наличие аннотации @Check
        if (targetMethod.isAnnotationPresent(Check.class)) {
            Check check = targetMethod.getAnnotation(Check.class);
            String[] expectedValues = check.value();

            // Валидируем параметры
            validateParameters(method.getName(), expectedValues, args, targetMethod.getParameterTypes());
        }


        return method.invoke(target, args);
    }

    private void validateParameters(String methodName, String[] expectedValues, Object[] args, Class<?>[] paramTypes){

        //Если количество указанных параметров в аннотации не равно количеству параметров в методе
        if (expectedValues.length != args.length){
            throw new IllegalArgumentException(
                    String.format("Метод %s: ожидалось %d параметров, получено %d",
                            methodName, expectedValues.length, args.length)
            );
        }

        for (int i = 0; i < args.length; i++){
            Object arg = args[i];
            String expectedValue = expectedValues[i];

            //Смотрим соответствие типов
            if(!isValueMatches(arg, expectedValue, paramTypes[i])){
                throw new IllegalArgumentException(
                        String.format("Метод %s: параметр %d (значение '%s') не соответствует ожидаемому '%s'",
                                methodName, i + 1, arg, expectedValue)
                        );
            }
        }
        System.out.println("Метод: " + methodName + " прошел валидацию");

    }

    //Как по-другому, не знаю, только так
    private boolean isValueMatches(Object arg, String expected, Class<?> paramType) {
        if (arg == null) {
            return expected == null || expected.equals("null");
        }

        // Сравниваем в зависимости от типа параметра
        if (paramType == int.class || paramType == Integer.class) {
            return Integer.parseInt(expected) == (int) arg;
        }
        if (paramType == double.class || paramType == Double.class) {
            return Double.parseDouble(expected) == (double) arg;
        }
        if (paramType == boolean.class || paramType == Boolean.class) {
            return Boolean.parseBoolean(expected) == (boolean) arg;
        }
        if (paramType == String.class) {
            return expected.equals(arg);
        }

        // Для других типов используем строковое представление
        return expected.equals(arg.toString());
    }
}
