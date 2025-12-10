package com.nemchann.geometry;

abstract class Figure implements Shiftable{
    protected Dot[] points;

    public Dot[] getPoints() {
        return points != null ? points.clone() : new Dot[0];
    }

    // Метод сдвига фигуры
    @Override
    public void shift(Coordinate coordinate, int value) {
        if (points == null) return;

        for (int i = 0; i < points.length; i++) {
            if (points[i] != null) {
                // Создаем новую точку со сдвигом
                points[i] = points[i].shifted(coordinate, value);
            }
        }
    }

    // Метод сдвига по X и Y (для 2D фигур)
    @Override
    public void shift(int dx, int dy) {
        if (points == null) return;

        for (int i = 0; i < points.length; i++) {
            if (points[i] != null) {
                points[i] = points[i].shifted(dx, dy);
            }
        }
    }
    public abstract Figure shifted(Coordinate coordinate, int value);
    public abstract Figure shifted(int dx, int dy);

    public abstract double getArea();

    public abstract String getType();

}
