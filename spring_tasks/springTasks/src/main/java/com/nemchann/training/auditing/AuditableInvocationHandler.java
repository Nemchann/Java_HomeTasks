package com.nemchann.training.auditing;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AuditableInvocationHandler implements InvocationHandler {
    private final Object target;

    public AuditableInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

            long startTime = System.currentTimeMillis();
            String argsString = (args == null || args.length == 0) ? "" : Arrays.toString(args);

            System.out.println("[AUDIT] " + targetMethod.getName() + "(" + argsString + ") -> начало");

            try{
                Object result = method.invoke(target, args);

                long endTime = System.currentTimeMillis();

                System.out.println("[AUDIT] " + targetMethod.getName() +
                        "(" + argsString + ") -> завершено за " + (endTime - startTime) + " миллисекунд");

                return result;
            }catch (Exception e){
                System.out.println("[AUDIT] " + targetMethod.getName() + " -> ОШИБКА: " + e.getCause().getMessage());
                throw e;
            }

    }
}
