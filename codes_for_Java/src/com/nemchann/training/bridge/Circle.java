package com.nemchann.training.bridge;

public class Circle extends Shape{
    public Circle(Renderer renderer){
        super(renderer);
    }
    @Override
    public void draw() {
        renderer.renderCircle();
        System.out.println("o");
    }
}
