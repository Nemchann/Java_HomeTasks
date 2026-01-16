package com.nemchann.data_bases;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Парсинг из строки вида "x,y"
    public static Point fromString(String value) {
        String[] parts = value.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid point format: " + value);
        }
        return new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public String toString() {
        return "Point(" + x + "," + y + ")";
    }
}
