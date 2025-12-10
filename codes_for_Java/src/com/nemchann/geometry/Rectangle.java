package com.nemchann.geometry;

public class Rectangle extends Figure implements AreasSummary, Brokable {
    private final int side1;
    private final int side2;
    private final Dot originalDot;

    public Rectangle(Dot dot, int side1, int side2){
        if (side1 <= 0 && side2 <= 0){
            throw new IllegalArgumentException("sides must be positive");
        }

        this.side1 = side1;
        this.side2 = side2;
        this.originalDot = dot.clone();

        updatePoints();
    }

    private void updatePoints() {
        Dot dot = this.originalDot;
        Dot dot2 = new Dot(dot.x + side1, dot.y);
        Dot dot3 = new Dot(dot.x + side1, dot.y + side2);
        Dot dot4 = new Dot(dot.x, dot.y + side2);

        this.points = new Dot[]{dot, dot2, dot3, dot4};
    }

    @Override
    public String getType() {
        return "com.sstu.war.geometry.Rectangle";
    }

    @Override
    public double getArea() {
        return side1 * side2;
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
    public Rectangle shifted(Coordinate coordinate, int value) {
        // Создаем новый квадрат со сдвигом
        Dot shiftedDot = this.originalDot.shifted(coordinate, value);
        return new Rectangle(shiftedDot, this.side1, this.side2);
    }

    @Override
    public Rectangle shifted(int dx, int dy) {
        // Создаем новый квадрат со сдвигом
        Dot shiftedDot = this.originalDot.shifted(dx, dy);
        return new Rectangle(shiftedDot, this.side1, this.side2);
    }
}
