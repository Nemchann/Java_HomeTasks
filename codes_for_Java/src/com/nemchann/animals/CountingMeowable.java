package com.nemchann.animals;

public class CountingMeowable implements Meowable{
    private Meowable decoratedMeowable;
    private int meowCount = 0;

    public CountingMeowable(Meowable meowable) {
        this.decoratedMeowable = meowable;
    }

    @Override
    public void meow() {
        decoratedMeowable.meow();
        meowCount++;
    }

    public int getMeowCount() {
        return meowCount;
    }
}
