package com.nemchann.training.bridge;

public class RasterRenderer implements Renderer{
    @Override
    public void renderCircle() {
        System.out.println("Отрисовываем растровый круг");
    }

    @Override
    public void renderSquare() {
        System.out.println("Отрисовываем растровый квадрат");
    }
}
