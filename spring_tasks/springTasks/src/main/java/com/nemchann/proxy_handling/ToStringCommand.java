package com.nemchann.proxy_handling;

import java.lang.reflect.Method;

public class ToStringCommand implements MethodCommand{
    @Override
    public Object execute(Object target, Method method, Object[] args) throws Throwable {
        // Логика: если вызывается метод toString(), выводим поля родителей
        if (method.getName().equals("toString")) {
            return "Custom ToString: " + target.getClass().getSuperclass().getSimpleName();
        }
        return method.invoke(target, args);
    }
}
