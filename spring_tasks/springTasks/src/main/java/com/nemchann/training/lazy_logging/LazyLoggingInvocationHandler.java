package com.nemchann.training.lazy_logging;

import com.nemchann.training.logging_processor.LogExecutionTime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LazyLoggingInvocationHandler implements InvocationHandler {
    private boolean silent = false;
    private final Object target;

    public LazyLoggingInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass() == Object.class){
            return method.invoke(target, args);
        }

        Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());


            if (targetMethod.getName().equals("silentMode")){
                this.silent = true;
                method.invoke(target, args);
            }
            if (targetMethod.getName().equals("normalMode")){
                this.silent = false;
                method.invoke(target,args);
        }

        setSilentField(target, silent);
        return method.invoke(target, args);
    }

    private void setSilentField(Object target, boolean silent) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField("silent");
            field.setAccessible(true);
            field.setBoolean(target, silent);
        } catch (Exception e) {
            // Если поле не найдено — игнорируем
        }
    }
}
