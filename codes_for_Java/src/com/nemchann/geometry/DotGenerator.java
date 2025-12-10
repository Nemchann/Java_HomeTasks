package com.nemchann.geometry;

public class DotGenerator {

    public static Dot createDot(int...coordinates){
        return switch (coordinates.length) {
            case 2 -> create2DDot(coordinates[0], coordinates[1]);
            case 3 -> create3DDot(coordinates[0], coordinates[1], coordinates[2]);
            default -> throw new IllegalArgumentException("Expected 2 or 3, got " + coordinates.length);
        };
    }

    public static Dot create2DDot(int x, int y){
        return new Dot(x, y);
    }

    public static ThreeCoordinatesDot create3DDot(int x, int y, int z){
        return new ThreeCoordinatesDot(x, y, z);
    }
}
