//class B {
//    int x;
//    public String toString(){
//        return x + "";
//    }
//}
//
//class A {
//    B b;
//
//    public String toString(){
//        return b.x + "";
//    }
//
//}
class Line {
//    Line line;
    int x1;
    int x2;

    int y1;
    int y2;

    public String toString(){
        return "Линия от {" + x1 + "; " + y1 + "} до {" + x2 + "; " + y2 + "}";
    }
}


public class Main {
    public static void main(String[] args) {

        Line line1 = new Line();
        line1.x1 = 1;
        line1.y1 = 3;
        line1.x2 = 23;
        line1.y2 = 8;

        Line line2 = new Line();
        line2.x1 = 5;
        line2.y1 = 10;
        line2.x2 = 25;
        line2.y2 = 10;

        line1.x1 = 9;
        line1.y1 = 2;
        line1.x2 = 45;
        line1.y2 = 50;

        Line line3 = new Line();
        line3.x1 = line1.x1;
        line3.y1 = line1.y1;
        line3.x2 = line2.x2;
        line3.y2 = line2.y2;

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        line1.x1 = 4;
        line1.y1 = 8;
        line1.x2 = 100;
        line1.y2 = 60;



        System.out.println("\n");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
//        int z = 32;
//        B b = new B();
//        b.x = z;
//        z = 77;
//        System.out.println(b);
//
//        B b2 = new B();
//        b2.x = 42;
//        A a = new A();
//        a.b = b2;
//        System.out.println(a);
//        b2.x = 77;
//        System.out.println(a);
    }
}