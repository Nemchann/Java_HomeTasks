public class Main {
    public static void main(String[] args) {
//        1
        Dot dot1 = new Dot();
        dot1.x = 1;
        dot1.y = 5;

        Dot dot2 = new Dot();
        dot2.x = 2;
        dot2.y = 8;

        Dot dot3 = new Dot();
        dot3.x = 5;
        dot3.y = 3;

        Dot[] pointsArray1 = {dot1, dot2, dot3};
        BrokenLine line1 = new BrokenLine();
        line1.points = pointsArray1;

        System.out.println(line1);

//        2

        Dot dot4 = new Dot();
        Dot dot5 = new Dot();
        dot4.x = 2;
        dot4.y = -5;
        dot5.x = 4;
        dot5.y = -8;

        Dot[] pointsArray2 = {pointsArray1[0], dot4, dot5, pointsArray1[2]};
        BrokenLine line2 = new BrokenLine();
        line2.points = pointsArray2;
        System.out.println(line2);
        System.out.println("\n");

//        3
        dot1.x = 0;
        dot1.y = -5;
        System.out.println(line1);
        System.out.println(line2);


    }
}