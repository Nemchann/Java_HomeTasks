package com.nemchann.reflexion_work;

public class A {
    @MeasureTime
    public void timeMethod() throws InterruptedException {
        for (int i = 0; i < 20; i++){
            Thread.sleep(100);
            System.out.println(i);
        }
    }
}
