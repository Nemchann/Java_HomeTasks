public class IntegerWrapper implements Numeric{
    private final int value;

    public IntegerWrapper(int value) {
        this.value = value;
    }

    @Override
    public double toDouble() {
        return (double) value;
    }
}
