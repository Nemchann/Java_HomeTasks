package com.nemchann.geometry;

import com.nemchann.mathematic.Fraction;

import java.util.Objects;

public sealed class Dot extends AbstractDot implements Cloneable, Shiftable permits ThreeCoordinatesDot {
    int x;
    int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String getDescription() {
        return "Точка в координате " + getCoordinates();
    }

    @Override
    public String getCoordinates() {
        return "{" + x + "; " + y + "}";
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
            default:
                throw new IllegalArgumentException("Unsupported coordinate: " + coordinate);
        }
    }

    public Dot shifted(Coordinate coordinate, int value) {
        switch (coordinate) {
            case X:
                return new Dot(this.x + value, this.y);
            case Y:
                return new Dot(this.x, this.y + value);
            default:
                throw new IllegalArgumentException("Unsupported coordinate: " + coordinate);
        }
    }
    public Dot shifted(int dx, int dy) {
        return new Dot(this.x + dx, this.y + dy);
    }

    @Override
    public void shift(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Dot dot = (Dot) obj;
        if (this.x != dot.x || this.y != dot.y){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    @Override
    public Dot clone(){
        try{
            return (Dot) super.clone();
        }catch(CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

}