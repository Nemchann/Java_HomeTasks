public class DoubleWrapper implements Numeric{
    private final double value;

    public DoubleWrapper(double value){
        this.value = value;
    }

    @Override
    public double toDouble() {
        return value;
    }
}
