public class NewSquare extends Figure{
    private final int side;

    public NewSquare(Dot dot, int side){
        if (side <= 0){
            throw new IllegalArgumentException("side must be positive");
        }

        this.side = side;
        Dot dot2 = new Dot(dot.x + side, dot.y);
        Dot dot3 = new Dot(dot.x + side, dot.y + side);
        Dot dot4 = new Dot(dot.x, dot.y + side);
//        this.points[0] = dot;
//        this.points[1] = dot2;
//        this.points[2] = dot3;
//        this.points[3] = dot4;
    }

    public NewSquare(Dot dot1, Dot dot2){
        if(dot1.equals(dot2)){
            throw new IllegalArgumentException("Dots must be different");
        }

//        this.points[0] = dot1;
//        this.points[1] = dot2;
        Line sideLine = new Line(dot1, dot2);
        this.side = sideLine.getSpace();
//        if (dot1.y == dot2.y){
//            Dot dot3 = new Dot(dot1.x + side, dot1.y + side);
//            Dot dot4 = new Dot(dot1.x + side, dot1.y);
//        }
//        else{
//            Dot dot3 = new Dot(dot1.x + side, dot1.y + side);
//            Dot dot4 = new Dot(dot1.x, dot1.y + side);
//        } - Подправить

    }

    @Override
    public double getArea() {
        double area = side * side;
        return area;
    }
}
