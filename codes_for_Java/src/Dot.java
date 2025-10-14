sealed class Dot extends AbstractDot permits ThreeCoordinatesDot{
    protected int x;
    protected int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String getDescription() {
        return "Точка в координате " + getCoordinates();
    }

    @Override
    public String getCoordinates() {
        return "{" + x + "; " + y + "}";
    }
}