public class Circle extends Figure{
    private final double radius;

    public Circle(Dot dot, double radius){
        if (radius <= 0){
            throw new IllegalArgumentException("Radius must be positive");
        }

        this.radius = radius;
        //this.points[0] = dot;
    }

    public Circle(Dot dot1, Dot dot2){
        //this.points[0] = dot1;
        Line radiusLine = new Line(dot1, dot2);
        this.radius = radiusLine.getSpace();
    }

    @Override
    public double getArea() {
        double area = Math.PI * radius * radius;
        return area;
    }
}
