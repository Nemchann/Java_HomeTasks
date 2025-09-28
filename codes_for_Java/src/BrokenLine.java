public class BrokenLine {
    Dot[] points;

    public BrokenLine(){}

    public BrokenLine(Dot...points){
        this.points = points;
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
