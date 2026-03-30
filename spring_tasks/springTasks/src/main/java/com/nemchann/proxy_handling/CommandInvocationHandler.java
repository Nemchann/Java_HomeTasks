package com.nemchann.proxy_handling;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class CommandInvocationHandler implements InvocationHandler {
    private final Object originalBean;
    private final List<MethodCommand> commands;

    public CommandInvocationHandler(Object originalBean, List<MethodCommand> commands) {
        this.originalBean = originalBean;
        this.commands = commands;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Мы можем прогнать вызов через все команды.
        // Для простоты: если это toString — отдаем результат ToStringCommand.
        // Для остальных методов — проверяем CacheCommand.

        for (MethodCommand command : commands) {
            // Тут логика может быть сложнее: команды могут дополнять друг друга
            // или прерывать выполнение (как Cache).
            if (shouldExecute(command, method)) {
                return command.execute(originalBean, method, args);
            }
        }

        // Если ни одна команда не перехватила управление — вызываем оригинал
        return method.invoke(originalBean, args);
    }

    private boolean shouldExecute(MethodCommand command, Method method) {
        if (command instanceof ToStringCommand && method.getName().equals("toString")) return true;
        if (command instanceof CacheCommand) return true; // Кеш обычно проверяет все методы
        return false;
    }
}
