package com.nemchann.geometry;

public final class ThreeCoordinatesDot extends Dot {
    private int z;

    public ThreeCoordinatesDot(int x, int y){
        super(x, y);
        this.z = 0;
    }
    ThreeCoordinatesDot(int x, int y, int z){
        this(x, y);
        this.z = z;
    }

    @Override
    public void shift(Coordinate coordinate, int value) {
        switch (coordinate) {
            case X:
                this.x += value;
                break;
            case Y:
                this.y += value;
                break;
            case Z:
                this.z += value;
                break;
            default:
                throw new IllegalArgumentException("Unsupported coordinate: " + coordinate);
        }
    }

    public ThreeCoordinatesDot shifted(int dx, int dy, int dz) {
        return new ThreeCoordinatesDot(this.x + dx, this.y + dy, this.z + dz);
    }
    @Override
    public String getDescription() {
        return "Точка в координате " + getCoordinates();
    }

    @Override
    public String getCoordinates() {
        return "{" + x + "; " + y + "; " + z + "}";
    }
}
