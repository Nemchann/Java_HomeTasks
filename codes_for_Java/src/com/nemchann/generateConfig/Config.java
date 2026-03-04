package com.nemchann.generateConfig;

public class Config {
    @Invoke
    public static Aclass createAClass(){
        return new Aclass("Это Aclass");
    }

    @Invoke
    public static Bclass createBclass(){
        return new Bclass(11);
    }
}
