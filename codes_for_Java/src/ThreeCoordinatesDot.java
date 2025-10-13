final class ThreeCoordinatesDot extends Dot{
    private int z;

    public ThreeCoordinatesDot(int x, int y){
        super(x, y);
        this.z = 0;
    }
    public ThreeCoordinatesDot(int x, int y, int z){
        this(x, y);
        this.z = z;
    }
    public String toString(){
        return "{" + x + "; " + y +  "; " + z + "}";
    }
}
