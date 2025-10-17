public class Rectangle extends Figure implements AreasSummary{
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

        this.points = new Dot[]{dot, dot2, dot3, dot4};
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }

    @Override
    public double sumAreas() {
        return getArea();
    }
}
