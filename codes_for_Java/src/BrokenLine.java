import java.util.Arrays;

public class BrokenLine {
    Dot[] points;

    public BrokenLine(){
        this.points = new Dot[0];
    }

    public BrokenLine(Dot...points){
        this.points = points;
    }

    public void addDots(Dot...newPoints){
        Dot[] combinedPoints = Arrays.copyOf(this.points, this.points.length + newPoints.length);
        System.arraycopy(newPoints, 0, combinedPoints, this.points.length, newPoints.length);
        this.points = combinedPoints;
    }

    public double splineLength(){
        double space = 0;
        if (points.length <= 1 || points == null){
            return 0;
        }
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
