public class BrokenLine {
    Dot[] points;

    public BrokenLine(){}

    public BrokenLine(Dot...points){
        this.points = points;
    }

//    public BrokenLine addDots(Dot...points){
//
//    }

    public double splineLength(){
        double space = 0;
        for (int i = 1; i < points.length; i++){
            Line line = new Line(points[i - 1], points[i]);
            space += line.getSpace();
        }
        return space;
    }

    public String toString(){
        String result = "Линия [";

        for (int i = 0; i < points.length; i++){
            result += points[i];
            if (i < points.length - 1){
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}
