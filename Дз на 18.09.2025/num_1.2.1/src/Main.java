
public class Main {
    public static void main(String[] args) {
//        1.
        Dot dot11 = new Dot();
        Dot dot12 = new Dot();

        dot11.x = 1;
        dot11.y = 3;
        dot12.x = 23;
        dot12.y = 8;

        Line line1 = new Line();
        line1.start = dot11;
        line1.end = dot12;
        System.out.println("Первая линия: " + line1);

//        2.
        Dot dot21 = new Dot();
        Dot dot22 = new Dot();

        dot21.x = 5;
        dot21.y = 10;
        dot22.x = 25;
        dot22.y = 10;

        Line line2 = new Line();
        line2.start = dot21;
        line2.end = dot22;
        System.out.println("Вторая линия: " + line2);

//        3.
        Line line3 = new Line();
        line3.start = dot11;
        line3.end = dot22;
        System.out.println("Третья линия: " + line3);

//        4.
        dot11.x = 30;
        dot11.y = -7;

        dot22.x = 60;
        dot22.y = 2;
        System.out.println("После изменения");
        System.out.println("Первая линия: " + line1);
        System.out.println("Вторая линия: " + line2);
        System.out.println("Третья линия: " + line3);

//        5.
        Dot dot13 = new Dot();

        dot13.x = -10;
        dot13.y = 0;

        line1.start = dot13;

        System.out.println("После второго изменения");
        System.out.println("Первая линия: " + line1);
        System.out.println("Третья линия: " + line3);

    }
}