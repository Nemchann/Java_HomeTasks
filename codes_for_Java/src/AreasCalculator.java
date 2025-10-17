public class AreasCalculator {

    public static double sum(AreasSummary...values){
        double result = 0.0;
        for (AreasSummary value : values){
            result += value.sumAreas();
        }
        return result;
    }
}
