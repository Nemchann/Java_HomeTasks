package com.nemchann.exam;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler {
    private Object bean;

    public TransactionHandler(Object bean){
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass() == Object.class){
            return method.invoke(bean, args);
        }

        Method targetMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());

        //Аргументы, которые были
        Object[] copyArgs = args.clone();

        //Если на методе есть аннотация
        if (targetMethod.isAnnotationPresent(Transaction.class) ){
            try{
                //Вызываем метод
                Object result = targetMethod.invoke(bean, args);
                System.out.println("Получилось для метода : " + targetMethod.getName());
                return result;
            }
            catch (Exception e){
                args = copyArgs;
                System.out.println("Не получилось, откатываемся. Метод: " + targetMethod.getName());
            }
        }

        return method.invoke(bean, args);
    }
}
