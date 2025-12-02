package com.nemchann.geometry;

import com.nemchann.mathematic.Fraction;

import java.util.Objects;

public sealed class Dot extends AbstractDot implements Cloneable permits ThreeCoordinatesDot {
    int x;
    final int y;

    public Dot(int x, int y) {
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