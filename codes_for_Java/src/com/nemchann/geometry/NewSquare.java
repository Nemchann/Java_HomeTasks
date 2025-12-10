package com.nemchann.geometry;

public class NewSquare extends Figure implements AreasSummary, Brokable {
    private final int side;
    private final Dot originalDot;

    public NewSquare(Dot dot, int side){
        if (side <= 0){
            throw new IllegalArgumentException("side must be positive");
        }

        this.side = side;
        this.originalDot = dot.clone(); // Сохраняем копию исходной точки

        updatePoints();
    }

    private void updatePoints() {
        Dot dot = this.originalDot;
        Dot dot2 = new Dot(dot.x + side, dot.y);
        Dot dot3 = new Dot(dot.x + side, dot.y + side);
        Dot dot4 = new Dot(dot.x, dot.y + side);

        this.points = new Dot[]{dot, dot2, dot3, dot4};
    }

    @Override
    public String getType() {
        return "com.sstu.war.geometry.Square";
    }

    @Override
    public double getArea() {
        double area = side * side;
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
    public NewSquare shifted(Coordinate coordinate, int value) {
        // Создаем новый квадрат со сдвигом
        Dot shiftedDot = this.originalDot.shifted(coordinate, value);
        return new NewSquare(shiftedDot, this.side);
    }

    @Override
    public NewSquare shifted(int dx, int dy) {
        // Создаем новый квадрат со сдвигом
        Dot shiftedDot = this.originalDot.shifted(dx, dy);
        return new NewSquare(shiftedDot, this.side);
    }
}
