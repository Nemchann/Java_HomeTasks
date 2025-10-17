public class NewSquare extends Figure implements AreasSummary{
    private final int side;

    public NewSquare(Dot dot, int side){
        if (side <= 0){
            throw new IllegalArgumentException("side must be positive");
        }

        this.side = side;
        Dot dot2 = new Dot(dot.x + side, dot.y);
        Dot dot3 = new Dot(dot.x + side, dot.y + side);
        Dot dot4 = new Dot(dot.x, dot.y + side);

        this.points = new Dot[]{dot, dot2, dot3, dot4};
    }

    @Override
    public String getType() {
        return "Square";
    }

    @Override
    public double getArea() {
        double area = side * side;
        return area;
    }

    @Override
    public double sumAreas() {
        return getArea();
    }
}
