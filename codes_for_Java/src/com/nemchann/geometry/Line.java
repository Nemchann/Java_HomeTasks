package com.nemchann.geometry;

import java.util.Objects;

public class Line<T extends Dot> implements Sizeable, Cloneable, Shiftable {
    private T start;
    private T end;

    public Line(T start, T end) {
        if (start.equals(end)){
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.end = end;
    }


    public Dot getStart() {
        return (T) start.clone();
    }

    public Dot getEnd() {
        return (T) end.clone();
    }

    public void setStart(T start) {
        this.start = (T) start.clone();
    }

    public void setEnd(T end) {
        this.start = (T) end.clone();
    }

    public int getSpace(){
        double space = Math.sqrt((Math.pow(end.x - start.x, 2)) + (Math.pow(end.y - start.y, 2)));
        return (int)space;
    }

    @Override
    public double getSize() {
        return getSpace();
    }

    @Override
    public void shift(Coordinate coordinate, int value) {
        // Сдвигаем обе точки линии
        start.shift(coordinate, value);
        end.shift(coordinate, value);
    }

    @Override
    public void shift(int dx, int dy) {
        // Сдвигаем обе точки линии
        start.x += dx;
        start.y += dy;
        end.x += dx;
        end.y += dy;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Line<?> line = (Line<?>) obj;
        return (this.start.equals(line.start) && this.end.equals(line.end)) || (this.start.equals(line.end) && this.end.equals(line.start));
    }

    @Override
    public int hashCode() {
//        return Objects.hash(start, end);
        int x1 = start.x;
        int x2 = end.x;
        int y1 = start.y;
        int y2 = end.y;
        Dot dotStart = new Dot(x1, y1);
        Dot dotEnd = new Dot(x2, y2);
        if(x1 <= x2){
            if (y1 <= y2){
                dotStart = new Dot(x1, y1);
                dotEnd = new Dot(x2, y2);
            }
            else{
                dotStart = new Dot(x1, y2);
                dotEnd = new Dot(x2, y1);
            }
        }
        else{
            if (y1 <= y2){
                dotStart = new Dot(x2, y1);
                dotEnd = new Dot(x1, y2);
            }
            else{
                dotStart = new Dot(x2, y2);
                dotEnd = new Dot(x1, y1);
            }
        }
        return Objects.hash(dotStart, dotEnd);
    }

    @Override
    public Line clone(){
        try{
            Line<T> result = (Line<T>) super.clone();
            result.start = (T) this.start.clone();
            result.end = (T) this.end.clone();
            return result;
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

    public void moveXto10(){
        int newX = 0;
        if (this.start.x >= 0){
            newX = this.start.x + 10;
        }
        else{
            newX = this.start.x - 10;
        }
        this.start.x = newX;
    }

    public String toString(){
        return "Линия от " + start + " до " + end;
    }
}
