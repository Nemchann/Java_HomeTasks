package com.nemchann.training.checking_parameteres;

import org.springframework.stereotype.Service;

//Сервис для тестирования реализует интерфейс AuthServiceInterface
//Обязательно аннотация @Service - это бин
@Service
public class AuthService implements AuthServiceInterface{

    @Override
    @Check({"admin", "secret123"})
    public String login(String username, String password) {
        return "Успешный вход: " + username;
    }

    @Override
    @Check({"100", "200"})
    public int calculateSum(int a, int b) {
        return a + b;
    }

    @Override
    @Check({"true"})
    public String processFlag(boolean flag) {
        return "Флаг: " + flag;
    }

    @Override
    // Метод без @Check — не проверяется
    public void freeMethod(String anyValue) {
        System.out.println("Свободный метод: " + anyValue);
    }
}
