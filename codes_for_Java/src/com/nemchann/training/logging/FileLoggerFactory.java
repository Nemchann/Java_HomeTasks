package com.nemchann.training.logging;

public class FileLoggerFactory extends LoggerFactory{

    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}
