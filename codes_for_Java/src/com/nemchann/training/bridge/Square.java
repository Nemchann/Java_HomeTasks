package com.nemchann.training.bridge;

public class Square extends Shape{
    public Square(Renderer renderer){
        super(renderer);
    }
    @Override
    public void draw() {
        renderer.renderSquare();
        System.out.println("п");
    }
}
