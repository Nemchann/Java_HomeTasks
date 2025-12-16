package com.nemchann.training.logging;

public class FileLogger implements Logger{

    @Override
    public void log(String message) {
        System.out.println("Запись в файл: " + message);
    }
}
