public class Calculator {
    // Метод принимает любые объекты, реализующие Numeric
    public static double sum(Numeric... values) {
        double result = 0.0;
        for (Numeric value : values) {
            result += value.toDouble();
        }
        return result;
    }
}
