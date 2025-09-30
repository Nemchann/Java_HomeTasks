public class Main {
    public static void main(String[] args) {
//        1.4.1
        Dot dot1 = new Dot(3, 5);
        Dot dot2 = new Dot(25, 6);
        Dot dot3 = new Dot(7, 8);
        System.out.println("1.4.1");
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
        System.out.println("1.4.2");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println("\n");

//        1.4.3
        Dot dot6 = new Dot(3, 5);
        Dot dot7 = new Dot(25, 6);
        Dot dot8 = new Dot(7, 8);
        BrokenLine spline1 = new BrokenLine(dot6, dot7, dot8);
        System.out.println("1.4.3");
        System.out.println(spline1);
        System.out.println("\n");

//        1.4.4
        House house1 = new House(2);
        House house2 = new House(35);
        House house3 = new House(91);
        System.out.println("1.4.4");
        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);
        System.out.println("\n");

//        1.4.5
        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Александр", "Сегреевич", "Пушкин");
        Name name3 = new Name("Владимир", "Маяковский");
        Name name4 = new Name("Христофор", "Бонифатьевич");
        System.out.println("1.4.5");
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
        System.out.println("1.4.6");
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println("\n");

//        1.4.7
        Student student1 = new Student("Вася", new int[]{3, 4, 5});
        Student student2 = new Student("Максим");
        System.out.println("1.4.7");
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
        System.out.println("1.4.8");
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);
        System.out.println("\n");

//        1.5.1
        Gun gun1 = new Gun(3,5);
        System.out.println("1.5.1");
        gun1.fire();
        gun1.fire();
        gun1.fire();
        gun1.fire();
        gun1.fire();
        System.out.println("\n");

//        1.5.2
        Cat cat1 = new Cat("Барсик");
        System.out.println("1.5.2");
        cat1.tellMeow();
        cat1.tellMeow(3);
        System.out.println("\n");

//        1.5.3
        Line line153 = new Line(1, 1, 10, 15);
        System.out.println("1.5.3");
        System.out.println(line153.getSpace());
        System.out.println("\n");

//        1.5.4
        System.out.println("1.5.4");
        Human human154_1 = new Human(new Name("Колыван", "Попов", "Прохорович"));
        Human human154_2 = new Human(human154_1, "Потап");
        Human human154_3 = new Human(human154_2, "Шут");
        System.out.println(human154_2.getSurname());
        System.out.println(human154_3.getSurname());
        System.out.println(human154_2);
        System.out.println(human154_3);
        System.out.println("\n");

//        1.5.5
        Fraction fraction1 = new Fraction(1, 3);
        Fraction fraction2 = new Fraction(2, 3);
        Fraction fraction3 = new Fraction(3, 8);
        Fraction fraction4 = new Fraction(5, 9);
        System.out.println("1.5.5");
        System.out.println(fraction1.sum(fraction3));
        System.out.println(fraction2.sum(2));
        System.out.println(fraction3.minus(fraction4));
        System.out.println(fraction2.minus(1));
        System.out.println(fraction4.mul(fraction2));
        System.out.println(fraction2.mul(2));
        System.out.println(fraction1.div(fraction4));
        System.out.println(fraction4.div(5));

        System.out.println(fraction1.sum(fraction2).div(fraction3).minus(5));
        System.out.println(fraction1.mul(fraction2));
        System.out.println("\n");

//        1.5.6
        Student student156_1 = new Student("Вася", new int[]{3, 4, 5, 4});
        Student student156_2 = new Student("Петя", new int[]{5, 5, 5, 5});
        System.out.println("1.5.6");
        student156_1.getInfo();
        student156_2.getInfo();
        System.out.println("\n");

//        1.5.7
        Dot dot157_1 = new Dot(1, 5);
        Dot dot157_2 = new Dot(2, 8);
        Dot dot157_3 = new Dot(5, 3);
        Dot dot157_4 = new Dot(5, 15);
        Dot dot157_5 = new Dot(8, 10);
        System.out.println("1.5.7");
        BrokenLine spline157 = new BrokenLine(dot157_1, dot157_2, dot157_3);
        System.out.println(spline157.splineLength());
        spline157.addDots(dot157_4, dot157_5);
        System.out.println("Новая длина: " + spline157.splineLength());
        System.out.println("\n");

//        1.5.8
        Square square1 = new Square(5, 3, 23);
        BrokenLine squareLine = square1.polyline();
        System.out.println("1.5.8");
        System.out.println(squareLine);
        System.out.println(squareLine.splineLength());
        squareLine.points[3] = new Dot(15, 25);
        System.out.println(squareLine.splineLength());
        System.out.println("\n");

//        1.6.1
        System.out.println("1.6.1");
        House house161_1 = new House(5);
//        House house161_2 = new House(-5);
        System.out.println(house161_1);
//        System.out.println(house161_2);

//        1.6.3
        Square square163_1 = new Square(new Dot(3, 5), 3);
//        square163_1.setSquare(0, 2, 4);
//        square163_1.getSquare();
        Square square163_2 = new Square(new Dot(9, 0), 5);
        square163_2.setSquare(1, 2, 4);
        square163_2.getSquare();
        System.out.println("\n");

//        1.6.4
        System.out.println("1.6.4");
        Fraction fraction164_1 = new Fraction(3, 6);
        System.out.println(fraction164_1);
//        fraction164_1.numerator = 4;
//        Fraction fraction164_2 = new Fraction(5, -6);
        System.out.println("\n");
        
//        1.6.5
        System.out.println("1.6.5");
        Gun gun2 = new Gun(3, 7);
        gun2.fire();
        gun2.fire();
        gun2.fire();
        gun2.fire();
        gun2.fire();
        gun2.reloading(8);
        gun2.fire();
        gun2.fire();
        gun2.unloading();
        gun2.fire();


    }


}