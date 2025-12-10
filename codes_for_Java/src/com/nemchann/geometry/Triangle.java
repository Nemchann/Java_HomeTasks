package com.nemchann.geometry;

public class Triangle extends Figure implements AreasSummary, Brokable {
    private final double side1;
    private final double side2;
    private final double side3;
    private final Dot originalDot1;
    private final Dot originalDot2;
    private final Dot originalDot3;

    public Triangle(Dot dot1, Dot dot2, Dot dot3){

        if (dot1.equals(dot2) && dot2.equals(dot3)){
            throw new IllegalArgumentException("Dots must be different");
        }
        this.originalDot1 = dot1.clone();
        this.originalDot2 = dot2.clone();
        this.originalDot3 = dot3.clone();

        updatePoints();

        Line line1 = new Line(dot1, dot2);
        Line line2 = new Line(dot2, dot3);
        Line line3 = new Line(dot1, dot3);

        this.side1 = line1.getSpace();
        this.side2 = line2.getSpace();
        this.side3 = line3.getSpace();

    }

    private void updatePoints() {
        Dot dot1 = this.originalDot1;
        Dot dot2 = this.originalDot2;
        Dot dot3 = this.originalDot3;

        this.points = new Dot[]{dot1, dot2, dot3};
    }

    @Override
    public String getType() {
        return "com.sstu.war.geometry.Triangle";
    }

    @Override
    public double getArea() {
        double p = (side1 + side2 + side3) / 2;

        double area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        return area;
    }

    @Override
    public double sumAreas() {
        return getArea();
    }

    @Override
    public BrokenLine getPolyline() {
        return new ClosedPolyline(points);
    }

    @Override
    public void shift(Coordinate coordinate, int value) {
        originalDot1.shift(coordinate, value);
        originalDot2.shift(coordinate, value);
        originalDot3.shift(coordinate, value);

        updatePoints();
    }

    @Override
    public void shift(int dx, int dy) {

        originalDot1.x += dx;
        originalDot1.y += dy;

        originalDot2.x += dx;
        originalDot2.y += dy;

        originalDot3.x += dx;
        originalDot3.y += dy;

        updatePoints();
    }

    @Override
    public Triangle shifted(Coordinate coordinate, int value) {
        Dot shiftedDot1 = this.originalDot1.shifted(coordinate, value);
        Dot shiftedDot2 = this.originalDot2.shifted(coordinate, value);
        Dot shiftedDot3 = this.originalDot3.shifted(coordinate, value);
        return new Triangle(shiftedDot1, shiftedDot2, shiftedDot3);
    }

    @Override
    public Triangle shifted(int dx, int dy) {
        // Создаем новый квадрат со сдвигом
        Dot shiftedDot1 = this.originalDot1.shifted(dx, dy);
        Dot shiftedDot2 = this.originalDot2.shifted(dx, dy);
        Dot shiftedDot3 = this.originalDot3.shifted(dx, dy);
        return new Triangle(shiftedDot1, shiftedDot2, shiftedDot3);
    }
}
