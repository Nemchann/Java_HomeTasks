package com.nemchann.geometry;

public class Circle extends Figure implements AreasSummary {
    private final double radius;

    public Circle(Dot dot, double radius){
        if (radius <= 0){
            throw new IllegalArgumentException("Radius must be positive");
        }

        this.radius = radius;
        this.points = new Dot[]{dot};
    }

    @Override
    public String getType() {
        return "com.sstu.war.geometry.Circle";
    }

    @Override
    public double getArea() {
        double area = Math.PI * radius * radius;
        return area;
    }

    @Override
    public double sumAreas() {
        return getArea();
    }
}
