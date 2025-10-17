public class AllSizes {
    public static double sumAllSizes(Sizeable...sizeables){
        double result = 0.0;
        for (Sizeable sizeable : sizeables){
            result += sizeable.getSize();
        }
        return result;
    }
}
