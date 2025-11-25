package com.nemchann.geometry;

import java.util.Objects;

public class Line implements Sizeable, Cloneable {
    private Dot start;
    private Dot end;

    public Line(Dot start, Dot end) {
        if (start.equals(end)){
            throw new IllegalArgumentException();
        }
        this.start = new Dot(start.x, start.y);
        this.end = new Dot(end.x, end.y);
    }

    public Line(int x1, int y1, int x2, int y2){
        if (x1 == x2 && y1 == y2){
            throw new IllegalArgumentException();
        }
        this.start = new Dot(x1, y1);
        this.end = new Dot(x2, y2);;
    }

    public Dot getStart() {
        return new Dot(start.x, start.y);
    }

    public Dot getEnd() {
        return new Dot(end.x, end.y);
    }

    public void setStart(Dot start) {
        this.start = new Dot(start.x, start.y);
    }

    public void setEnd(Dot end) {
        this.end = new Dot(end.x, end.y);
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
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Line line = (Line) obj;
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
            Line result = (Line) super.clone();
            result.start = this.start.clone();
            result.end = this.end.clone();
            return result;
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

    public String toString(){
        return "Линия от " + start + " до " + end;
    }
}
