public class Square {
    int n;
    Dot dot;

    public Square(Dot dot, int n){
        this.dot = dot;
        if (n <= 0){
            throw new IllegalArgumentException("n must be positive");
        }
        this.n = n;
    }

    public Square(int x, int y, int n){
        dot = new Dot(x, y);
        if (n <= 0){
            throw new IllegalArgumentException("n must be positive");
        }
        this.n = n;
    }


    void setSquare(int n, Dot dot){
        this.dot = dot;
        if (n <= 0){
            throw new IllegalArgumentException("n must be positive");
        }
        this.n = n;

    }

    void setSquare(int n, int x, int y){
        dot = new Dot(x, y);
        if (n <= 0){
            throw new IllegalArgumentException("n must be positive");
        }
        this.n = n;
    }

    public BrokenLine polyline(){
        int x1 = dot.x;
        int y1 = dot.y;
        Dot dot2 = new Dot(x1 + n, y1);
        Dot dot3 = new Dot(x1 + n, y1 - n);
        Dot dot4 = new Dot(x1, y1 - n);
        BrokenLine squareLine = new BrokenLine(dot, dot2, dot3, dot4);
        return squareLine;
    }

    public void getSquare(){
        System.out.println("Квадрат в точке " + dot + " со стороной " + n);
    }
}
