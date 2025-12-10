package com.nemchann.geometry;

public interface Shiftable {
    void shift(Coordinate coordinate, int value);
    void shift(int dx, int dy);
}
