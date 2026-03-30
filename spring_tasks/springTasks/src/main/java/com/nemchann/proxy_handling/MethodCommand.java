package com.nemchann.proxy_handling;

import java.lang.reflect.Method;

public interface MethodCommand {
    Object execute(Object target, Method method, Object[] args) throws Throwable;
}
