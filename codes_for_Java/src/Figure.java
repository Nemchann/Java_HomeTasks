abstract class Figure {
    protected Dot[] points;

    public Dot[] getPoints() {
        return points != null ? points.clone() : new Dot[0];
    }



    public abstract double getArea();

    public abstract String getType();

}
