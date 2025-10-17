public class Triangle extends Figure implements AreasSummary{
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(Dot dot1, Dot dot2, Dot dot3){

        if (dot1.equals(dot2) && dot2.equals(dot3)){
            throw new IllegalArgumentException("Dots must be different");
        }

        this.points = new Dot[]{dot1, dot2, dot3};

        Line line1 = new Line(dot1, dot2);
        Line line2 = new Line(dot2, dot3);
        Line line3 = new Line(dot1, dot3);

        this.side1 = line1.getSpace();
        this.side2 = line2.getSpace();
        this.side3 = line3.getSpace();

    }

    @Override
    public String getType() {
        return "Triangle";
    }

    @Override
    public double getArea() {
        double p = (side1 + side2 + side3) / 2;

        double area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        return area;
    }

    @Override
    public double sumAreas() {
        return getArea();
    }
}
