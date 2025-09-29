public class Line {
    Dot start;
    Dot end;

    public Line(Dot start, Dot end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2){
        this.start = new Dot(x1, y1);
        this.end = new Dot(x2, y2);;
    }

    public int getSpace(){
        double space = Math.sqrt((Math.pow(end.x - start.x, 2)) + (Math.pow(end.y - start.y, 2)));
        return (int)space;
    }

    public String toString(){
        return "Линия от " + start + " до " + end;
    }
}
