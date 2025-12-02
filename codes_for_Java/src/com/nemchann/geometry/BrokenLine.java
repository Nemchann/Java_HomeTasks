package com.nemchann.geometry;

import java.util.Arrays;
import java.util.Objects;

public class BrokenLine implements Sizeable, Brokable {
    Dot[] points;

    public BrokenLine(){
        this.points = new Dot[0];
    }

    public BrokenLine(Dot...points){
        this.points = points;
    }

    public void addDots(Dot...newPoints){
        Dot[] combinedPoints = Arrays.copyOf(this.points, this.points.length + newPoints.length);
        System.arraycopy(newPoints, 0, combinedPoints, this.points.length, newPoints.length);
        this.points = combinedPoints;
    }

    public double splineLength(){
        double space = 0;
        if (points.length <= 1 || points == null){
            return 0;
        }
        for (int i = 1; i < points.length; i++){
            Line<Dot> line = new Line<>(points[i - 1], points[i]);
            space += line.getSpace();
        }
        return space;
    }

    @Override
    public double getSize() {
        return splineLength();
    }

    @Override
    public BrokenLine getPolyline() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if (!(o instanceof BrokenLine)) return false;

        BrokenLine that = (BrokenLine) o;

        if (this.getClass() == that.getClass()) {
            return Arrays.equals(this.points, that.points);
        }

        return compareDifferentTypes(that);


    }

    private boolean compareDifferentTypes(BrokenLine that) {
        BrokenLine broken, closed;

        if (this instanceof ClosedPolyline && that instanceof BrokenLine) {
            closed = this;
            broken = that;
        } else if (this instanceof BrokenLine && that instanceof ClosedPolyline) {
            broken = this;
            closed = that;
        } else {
            return false;
        }

        return isBrokenEqualClosed(broken, (ClosedPolyline) closed);
    }
    private boolean isBrokenEqualClosed(BrokenLine broken, ClosedPolyline closed) {
        // BrokenLine должен быть замкнут
        if (broken.points.length == 0 ||
                !broken.points[0].equals(broken.points[broken.points.length - 1])) {
            return false;
        }

        // Количество точек: у BrokenLine на 1 больше
        if (broken.points.length - 1 != closed.points.length) {
            return false;
        }

        for (int i = 0; i < closed.points.length; i++) {
            if (!broken.points[i].equals(closed.points[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    public String toString(){
        String result = "Линия [";

        for (int i = 0; i < points.length; i++){
            result += points[i];
            if (i < points.length - 1){
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

}
