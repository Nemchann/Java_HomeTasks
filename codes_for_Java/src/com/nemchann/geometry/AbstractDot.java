package com.nemchann.geometry;

abstract public class AbstractDot {
    public abstract String getDescription();
    public abstract String getCoordinates();

    @Override
    public String toString() {
        return getDescription();
    }
}
