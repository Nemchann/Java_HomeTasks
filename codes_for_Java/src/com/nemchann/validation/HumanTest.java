package com.nemchann.validation;

public class HumanTest {
    public static void testPositiveAge(Human human){
        if (human.getAge() <= 0){
            throw new IllegalArgumentException("age must be positive");
        }
    }

    public static void testTooOld(Human human){
        if (human.getAge() >= 170){
            throw new IllegalArgumentException("too old human, he couldn't be soo old");
        }
    }

    public static void testTooLongName(Human human){
        if (human.getName().length() >= 150){
            throw new IllegalArgumentException("too long name, it couldn't be so long");
        }
    }
}
