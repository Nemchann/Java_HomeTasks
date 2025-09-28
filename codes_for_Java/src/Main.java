public class Main {
    public static void main(String[] args) {
//        1.4.1
        Dot dot1 = new Dot(3, 5);
        Dot dot2 = new Dot(25, 6);
        Dot dot3 = new Dot(7, 8);
        System.out.println(dot1);
        System.out.println(dot2);
        System.out.println(dot3);
        System.out.println("\n");

//        1.4.2
        Dot dot4 = new Dot(1, 3);
        Dot dot5 = new Dot(23, 8);
        Line line1 = new Line(dot4, dot5);
        Line line2 = new Line(5, 10, 25, 10);
        Line line3 = new Line(line1.start, line2.end);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println("\n");

//        1.4.3
        Dot dot6 = new Dot(3, 5);
        Dot dot7 = new Dot(25, 6);
        Dot dot8 = new Dot(7, 8);
        BrokenLine spline1 = new BrokenLine(dot6, dot7, dot8);
        System.out.println(spline1);
        System.out.println("\n");

//        1.4.4
        House house1 = new House(2);
        House house2 = new House(35);
        House house3 = new House(91);
        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);
        System.out.println("\n");

//        1.4.5
        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Александр", "Сегреевич", "Пушкин");
        Name name3 = new Name("Владимир", "Маяковский");
        Name name4 = new Name("Христофор", "Бонифатьевич");
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
        System.out.println("\n");

//        1.4.6
        Human human1 = new Human("Лев");
        Name name5 = new Name("Сергей", "Пушкин");
        Human human2 = new Human(human1, name5);
        Human human3 = new Human(human2, "Александр");
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println("\n");

//        1.4.7
        Student student1 = new Student("Вася", new int[]{3, 4, 5});
        Student student2 = new Student("Максим");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println("\n");

//        1.4.8
        City A = new City("A");
        City C = new City("C");
        City E = new City("E");
        City B = new City("B", new Path(A, 5), new Path(C, 3));
        A.addPaths(B, 5);
        City D = new City("D", new Path(A, 6), new Path(C, 4), new Path(E, 2));
        C.addPaths(B, 3);
        C.addPaths(D, 4);
        City F = new City("F", new Path(A, 1), new Path(B, 1), new Path(E, 2));
        A.addPaths(D, 6);
        A.addPaths(F, 1);
        E.addPaths(F, 2);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);
        System.out.println("\n");

//        1.5.1
        Gun gun1 = new Gun(3);
        gun1.fire();
        gun1.fire();
        gun1.fire();
        gun1.fire();
        gun1.fire();
        System.out.println("\n");

//        1.5.2
        Cat cat1 = new Cat("Барсик");
        cat1.tellMeow();
        cat1.tellMeow(3);
        System.out.println("\n");

//        1.5.3
        Line line153 = new Line(1, 1, 10, 15);
        line153.getSpace();
        System.out.println("\n");


//        1.5.5
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);
        Fraction fraction3 = new Fraction(3, 8);
        System.out.println(fraction1.sum(fraction2).div(fraction3).minus(5));



    }

}