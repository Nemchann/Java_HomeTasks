public class Rectangle extends Figure{
    private final int side1;
    private final int side2;

    public Rectangle(Dot dot, int side1, int side2){
        if (side1 <= 0 && side2 <= 0){
            throw new IllegalArgumentException("sides must be positive");
        }

        this.side1 = side1;
        this.side2 = side2;

        Dot dot2 = new Dot(dot.x + side1, dot.y);
        Dot dot3 = new Dot(dot.x + side1, dot.y + side2);
        Dot dot4 = new Dot(dot.x, dot.y + side2);

//        this.points[0] = dot;
//        this.points[1] = dot2;
//        this.points[2] = dot3;
//        this.points[3] = dot4;
    }

    @Override
    public double getArea() {
        double area = (side1 + side2) * 2;
        return area;
    }
}
