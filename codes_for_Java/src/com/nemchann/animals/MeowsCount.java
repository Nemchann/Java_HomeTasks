package com.nemchann.animals;

public class MeowsCount implements Meowable{

    private Meowable decoratedMeowable;
    private int meowCount = 0;

//    public static int meowsCount(Meowable meowable) {
//        return meowable
//    }

    public void CountingMeowable(Meowable meowable) {
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
