package com.nemchann.animals;

import java.net.DatagramPacket;

public class CatDog implements Meowable, Barkable{
    private Cat cat;
    private Dog dog;
    private String name;

    public CatDog(Cat cat, Dog dog){
        this.cat = cat;
        this.dog = dog;
    }

    public CatDog(String name){
        this.cat = new Cat(name);
        this.dog = new Dog(name);
        this.name = name;
    }

    @Override
    public void meow() {
        cat.meow();
    }

    @Override
    public void bark() {
        dog.bark();
    }

    // Методы для ссылочной совместимости

    // Метод для получения ссылки на кота
    public Cat asCat() {
        return cat;
    }

    // Метод для получения ссылки на собаку
    public Dog asDog() {
        return dog;
    }

    // Или можно использовать геттеры
    public Cat getCat() {
        return cat;
    }

    public Dog getDog() {
        return dog;
    }
}
