package com.nemchann.geometry;

public class Circle extends Figure implements AreasSummary {
    private final double radius;
    private final Dot originalDot;

    public Circle(Dot dot, double radius){
        if (radius <= 0){
            throw new IllegalArgumentException("Radius must be positive");
        }

        this.radius = radius;
        this.originalDot = dot.clone();
        updatePoints();
    }

    private void updatePoints() {
        Dot dot = this.originalDot;

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

    @Override
    public void shift(Coordinate coordinate, int value) {
        originalDot.shift(coordinate, value);

        updatePoints();
    }

    @Override
    public void shift(int dx, int dy) {

        originalDot.x += dx;
        originalDot.y += dy;

        updatePoints();
    }

    @Override
    public Circle shifted(Coordinate coordinate, int value) {
        // Создаем новый квадрат со сдвигом
        Dot shiftedDot = this.originalDot.shifted(coordinate, value);
        return new Circle(shiftedDot, this.radius);
    }

    @Override
    public Circle shifted(int dx, int dy) {
        // Создаем новый квадрат со сдвигом
        Dot shiftedDot = this.originalDot.shifted(dx, dy);
        return new Circle(shiftedDot, this.radius);
    }
}
