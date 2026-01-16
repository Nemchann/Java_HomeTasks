package com.nemchann.training.bridge;

public class VectorRenderer implements Renderer{
    @Override
    public void renderCircle() {
        System.out.println("Отрисовываем векторный круг");
    }

    @Override
    public void renderSquare() {
        System.out.println("Отрисовываем векторный квадрат");
    }
}
