package com.nemchann.training.checking_parameteres;


//Нужен для того, чтобы создать Proxy. Без интерфейса мы не сможем это сделать.
// В метод для создания Proxy также передаются интерфейсы класса
public interface AuthServiceInterface {
    String login(String username, String password);
    int calculateSum(int a, int b);
    String processFlag(boolean flag);
    void freeMethod(String anyValue);
}
