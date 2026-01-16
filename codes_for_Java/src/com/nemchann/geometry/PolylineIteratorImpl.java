package com.nemchann.geometry;

import java.util.Arrays;

public class PolylineIteratorImpl implements PolylineIterator{
    private final Dot[] points;
    private final boolean isCyclic; // true для ClosedPolyline, false для BrokenLine
    private int currentIndex;

    public PolylineIteratorImpl(Dot[] points, boolean isCyclic) {
        this.points = Arrays.copyOf(points, points.length);
        this.isCyclic = isCyclic;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        if (points.length == 0) {
            return false;
        }

        if (isCyclic) {
            // Для замкнутой полилинии всегда есть следующая точка (циклично)
            return true;
        } else {
            // Для обычной ломаной есть следующая точка, если не достигнут конец
            return currentIndex < points.length - 1;
        }
    }

    @Override
    public Dot next() {
        if (points.length == 0) {
            throw new IllegalStateException("No points in polyline");
        }

        if (!hasNext() && !isCyclic) {
            throw new IllegalStateException("No more points in broken line");
        }

        // Получаем текущую точку
        Dot currentPoint = points[currentIndex];

        // Перемещаем курсор
        if (isCyclic) {
            // Для замкнутой полилинии двигаемся по кругу
            currentIndex = (currentIndex + 1) % points.length;
        } else {
            // Для обычной ломаной двигаемся до конца
            if (currentIndex < points.length - 1) {
                currentIndex++;
            }
        }

        return currentPoint;
    }

    @Override
    public Dot current() {
        if (points.length == 0) {
            throw new IllegalStateException("No points in polyline");
        }
        return points[currentIndex];
    }

    @Override
    public void reset() {
        this.currentIndex = 0;
    }

    @Override
    public void setPosition(int index) {
        if (index < 0 || index >= points.length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        this.currentIndex = index;
    }

    // Дополнительные полезные методы
    public int getPosition() {
        return currentIndex;
    }

    public int getTotalPoints() {
        return points.length;
    }

    public boolean isCyclic() {
        return isCyclic;
    }
}
