package com.nemchann.geometry;

public class Line implements Sizeable, Cloneable {
    private Dot start;
    private Dot end;

    public Line(Dot start, Dot end) {
        this.start = new Dot(start.x, start.y);
        this.end = new Dot(end.x, end.y);
    }

    public Line(int x1, int y1, int x2, int y2){
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
//        if ((this.start.equals(line.start) && this.end.equals(line.end)) || (this.start.equals(line.end) && this.end.equals(line.start))){
//            return true;
//        }
        return (this.start.equals(line.start) && this.end.equals(line.end)) || (this.start.equals(line.end) && this.end.equals(line.start));
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
