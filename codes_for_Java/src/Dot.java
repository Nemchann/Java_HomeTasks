sealed class Dot permits ThreeCoordinatesDot{
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "{" + x + "; " + y + "}";
    }
}