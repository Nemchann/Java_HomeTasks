public class Line implements Sizeable{
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

    public String toString(){
        return "Линия от " + start + " до " + end;
    }
}
