package com.nemchann.geometry;

abstract public class AbstractDot {
    public abstract void shift(Coordinate coordinate, int value);
    public abstract String getDescription();
    public abstract String getCoordinates();

    @Override
    public String toString() {
        return getDescription();
    }
}
