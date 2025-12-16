package com.nemchann.util;

import com.nemchann.training.app.AppConfig;
import com.nemchann.training.logging.*;
import com.nemchann.training.building.User;

public class TrainingTest {
    public static void ex1_1(){
        AppConfig appConfig = AppConfig.getInstance();
        AppConfig appConfig1 = AppConfig.getInstance();

        System.out.println(appConfig1 == appConfig);
        System.out.println(appConfig.getAppName());
        System.out.println(appConfig1.getAppName());
    }

    public static void ex1_2(){
        // Клиентский код работает ТОЛЬКО с абстракциями
        LoggerFactory factory = new FileLoggerFactory();
        Logger logger = factory.createLogger(); // Создаем логгер через фабрику

        logger.log("Лог запустился");

        // Демонстрация смены фабрики
        factory = new ConsoleLoggerFactory();
        logger = factory.createLogger();
        logger.log("Теперь логируем в консоль");
    }

    public static void ex1_3(){
        User user = new User.UserBuilder("Василий", "Евгеньев")
                .setAddress("Саратов")
                .setAge(26)
                .setPhone("=79371223344")
                .build();
        System.out.println(user);
    }
}
