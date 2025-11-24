package com.nemchann.util;

import com.nemchann.animals.*;
import com.nemchann.banks.BankAccount;
import com.nemchann.cities.City;
import com.nemchann.cities.InnovativeCity;
import com.nemchann.geometry.BrokenLine;
import com.nemchann.geometry.ClosedPolyline;
import com.nemchann.geometry.Dot;
import com.nemchann.geometry.Line;
import com.nemchann.internet_connections.*;
import com.nemchann.internet_connections.ExampleConnector;
import com.nemchann.internet_connections.TestConnect;
import com.nemchann.mathematic.*;
import com.nemchann.students.GradeGenerator;
import com.nemchann.students.Student;
import com.nemchann.war.Gun;

import java.math.BigInteger;
import java.util.Arrays;
import java.awt.Point;
import java.util.Scanner;

public class MainTest {
//    public static void task1_4_1(){
//        com.sstu.war.geometry.Dot dot1 = new com.sstu.war.geometry.Dot(3, 5);
//        com.sstu.war.geometry.Dot dot2 = new com.sstu.war.geometry.Dot(25, 6);
//        com.sstu.war.geometry.Dot dot3 = new com.sstu.war.geometry.Dot(7, 8);
//        System.out.println("1.4.1");
//        System.out.println(dot1);
//        System.out.println(dot2);
//        System.out.println(dot3);
//        System.out.println("\n");
//    }
//
//    public static void task1_4_2(){
//        com.sstu.war.geometry.Dot dot4 = new com.sstu.war.geometry.Dot(1, 3);
//        com.sstu.war.geometry.Dot dot5 = new com.sstu.war.geometry.Dot(23, 8);
//        com.sstu.war.geometry.Line line1 = new com.sstu.war.geometry.Line(dot4, dot5);
//        com.sstu.war.geometry.Line line2 = new com.sstu.war.geometry.Line(5, 10, 25, 10);
//        com.sstu.war.geometry.Line line3 = new com.sstu.war.geometry.Line(line1.getStart(), line2.getEnd());
//        System.out.println("1.4.2");
//        System.out.println(line1);
//        System.out.println(line2);
//        System.out.println(line3);
//        System.out.println("\n");
//    }
//
//    public static void task1_4_3(){
//        com.sstu.war.geometry.Dot dot6 = new com.sstu.war.geometry.Dot(3, 5);
//        com.sstu.war.geometry.Dot dot7 = new com.sstu.war.geometry.Dot(25, 6);
//        com.sstu.war.geometry.Dot dot8 = new com.sstu.war.geometry.Dot(7, 8);
//        com.sstu.war.geometry.BrokenLine spline1 = new com.sstu.war.geometry.BrokenLine(dot6, dot7, dot8);
//        System.out.println("1.4.3");
//        System.out.println(spline1);
//        System.out.println("\n");
//    }
//
//    public static void task1_4_4(){
//        com.sstu.houses.House house1 = new com.sstu.houses.House(2);
//        com.sstu.houses.House house2 = new com.sstu.houses.House(35);
//        com.sstu.houses.House house3 = new com.sstu.houses.House(91);
//        System.out.println("1.4.4");
//        System.out.println(house1);
//        System.out.println(house2);
//        System.out.println(house3);
//        System.out.println("\n");
//    }
//
//    public static void task1_4_5(){
//        com.sstu.people.Name name1 = new com.sstu.people.Name("Клеопатра");
//        com.sstu.people.Name name2 = new com.sstu.people.Name("Александр", "Сегреевич", "Пушкин");
//        com.sstu.people.Name name3 = new com.sstu.people.Name("Владимир", "Маяковский");
//        com.sstu.people.Name name4 = new com.sstu.people.Name("Христофор", "Бонифатьевич");
//        System.out.println("1.4.5");
//        System.out.println(name1);
//        System.out.println(name2);
//        System.out.println(name3);
//        System.out.println(name4);
//        System.out.println("\n");
//    }
//
//    public static void task1_4_6(){
//        com.sstu.people.Human human1 = new com.sstu.people.Human("Лев");
//        com.sstu.people.Name name5 = new com.sstu.people.Name("Сергей", "Пушкин");
//        com.sstu.people.Human human2 = new com.sstu.people.Human(human1, name5);
//        com.sstu.people.Human human3 = new com.sstu.people.Human(human2, "Александр");
//        System.out.println("1.4.6");
//        System.out.println(human1);
//        System.out.println(human2);
//        System.out.println(human3);
//        System.out.println("\n");
//    }
//
//    public static void task1_4_7(){
//        com.sstu.students.Student student1 = new com.sstu.students.Student("Вася", 3, 4, 5);
//        com.sstu.students.Student student2 = new com.sstu.students.Student("Максим");
//        System.out.println("1.4.7");
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println("\n");
//    }
//
//    public static void task1_4_8(){
//        com.sstu.cities.City A = new com.sstu.cities.City("A");
//        com.sstu.cities.City C = new com.sstu.cities.City("C");
//        com.sstu.cities.City E = new com.sstu.cities.City("E");
//        com.sstu.cities.City B = new com.sstu.cities.City("B", new com.sstu.cities.Path(A, 5), new com.sstu.cities.Path(C, 3));
//        A.addPaths(B, 5);
//        com.sstu.cities.City D = new com.sstu.cities.City("D", new com.sstu.cities.Path(A, 6), new com.sstu.cities.Path(C, 4), new com.sstu.cities.Path(E, 2));
//        C.addPaths(B, 3);
//        C.addPaths(D, 4);
//        com.sstu.cities.City F = new com.sstu.cities.City("F", new com.sstu.cities.Path(A, 1), new com.sstu.cities.Path(B, 1), new com.sstu.cities.Path(E, 2));
//        A.addPaths(D, 6);
//        A.addPaths(F, 1);
//        E.addPaths(F, 2);
//        System.out.println("1.4.8");
//        System.out.println(A);
//        System.out.println(B);
//        System.out.println(C);
//        System.out.println(D);
//        System.out.println(E);
//        System.out.println(F);
//        System.out.println("\n");
//    }
//
//    public static void task1_5_1(){
//        com.sstu.war.Gun gun1 = new com.sstu.war.Gun(3,5);
//        System.out.println("1.5.1");
//        gun1.fire();
//        gun1.fire();
//        gun1.fire();
//        gun1.fire();
//        gun1.fire();
//        System.out.println("\n");
//    }
//
//    public static void task1_5_2(){
//        com.sstu.animals.Cat cat1 = new com.sstu.animals.Cat("Барсик");
//        System.out.println("1.5.2");
//        cat1.tellMeow();
//        cat1.tellMeow(3);
//        System.out.println("\n");
//    }
//
//    public static void task1_5_3(){
//        com.sstu.war.geometry.Line line153 = new com.sstu.war.geometry.Line(1, 1, 10, 15);
//        System.out.println("1.5.3");
//        System.out.println(line153.getSpace());
//        System.out.println("\n");
//    }
//
//    public static void task1_5_4(){
//        System.out.println("1.5.4");
//        com.sstu.people.Human human154_1 = new com.sstu.people.Human(new com.sstu.people.Name("Колыван", "Попов", "Прохорович"));
//        com.sstu.people.Human human154_2 = new com.sstu.people.Human(human154_1, "Потап");
//        com.sstu.people.Human human154_3 = new com.sstu.people.Human(human154_2, "Шут");
//        System.out.println(human154_2.getSurname());
//        System.out.println(human154_3.getSurname());
//        System.out.println(human154_2);
//        System.out.println(human154_3);
//        System.out.println("\n");
//    }
//
//    public static void task1_5_5(){
//        com.sstu.mathematic.Fraction fraction1 = new com.sstu.mathematic.Fraction(1, 3);
//        com.sstu.mathematic.Fraction fraction2 = new com.sstu.mathematic.Fraction(2, 3);
//        com.sstu.mathematic.Fraction fraction3 = new com.sstu.mathematic.Fraction(3, 8);
//        com.sstu.mathematic.Fraction fraction4 = new com.sstu.mathematic.Fraction(5, 9);
//        System.out.println("1.5.5");
//        System.out.println(fraction1.sum(fraction3));
//        System.out.println(fraction2.sum(2));
//        System.out.println(fraction3.minus(fraction4));
//        System.out.println(fraction2.minus(1));
//        System.out.println(fraction4.mul(fraction2));
//        System.out.println(fraction2.mul(2));
//        System.out.println(fraction1.div(fraction4));
//        System.out.println(fraction4.div(5));
//
//        System.out.println(fraction1.sum(fraction2).div(fraction3).minus(5));
//        System.out.println(fraction1.mul(fraction2));
//        System.out.println("\n");
//    }
//
//    public static void task1_5_6(){
//        com.sstu.students.Student student156_1 = new com.sstu.students.Student("Вася", new int[]{3, 4, 5, 4});
//        com.sstu.students.Student student156_2 = new com.sstu.students.Student("Петя", new int[]{5, 5, 5, 5});
//        System.out.println("1.5.6");
//        student156_1.getInfo();
//        student156_2.getInfo();
//        System.out.println("\n");
//    }
//
//    public static void task1_5_7(){
//        com.sstu.war.geometry.Dot dot157_1 = new com.sstu.war.geometry.Dot(1, 5);
//        com.sstu.war.geometry.Dot dot157_2 = new com.sstu.war.geometry.Dot(2, 8);
//        com.sstu.war.geometry.Dot dot157_3 = new com.sstu.war.geometry.Dot(5, 3);
//        com.sstu.war.geometry.Dot dot157_4 = new com.sstu.war.geometry.Dot(5, 15);
//        com.sstu.war.geometry.Dot dot157_5 = new com.sstu.war.geometry.Dot(8, 10);
//        System.out.println("1.5.7");
//        com.sstu.war.geometry.BrokenLine spline157 = new com.sstu.war.geometry.BrokenLine(dot157_1, dot157_2, dot157_3);
//        System.out.println(spline157.splineLength());
//        spline157.addDots(dot157_4, dot157_5);
//        System.out.println("Новая длина: " + spline157.splineLength());
//        System.out.println("\n");
//    }
//
//    public static void task1_5_8(){
//        com.sstu.war.geometry.Square square1 = new com.sstu.war.geometry.Square(5, 3, 23);
//        com.sstu.war.geometry.BrokenLine squareLine = square1.polyline();
//        System.out.println("1.5.8");
//        System.out.println(squareLine);
//        System.out.println(squareLine.splineLength());
//        squareLine.points[3] = new com.sstu.war.geometry.Dot(15, 25);
//        System.out.println(squareLine.splineLength());
//        System.out.println("\n");
//    }
//
//    public static void task1_6_1(){
//        System.out.println("1.6.1");
//        com.sstu.houses.House house161_1 = new com.sstu.houses.House(5);
////        com.sstu.houses.House house161_2 = new com.sstu.houses.House(-5);
//        System.out.println(house161_1);
////        System.out.println(house161_2);
//        System.out.println("\n");
//    }
//
//    public static void task1_6_2(){
//        System.out.println("1.6.2");
//        com.sstu.people.Name name6 = new com.sstu.people.Name("", "Смирнов");
////        com.sstu.people.Name name7 = new com.sstu.people.Name("");
//        System.out.println(name6);
////        System.out.println(name7);
//        System.out.println("\n");
//    }
//
//    public static void task1_6_3(){
//        System.out.println("1.6.3");
//        com.sstu.war.geometry.Square square163_1 = new com.sstu.war.geometry.Square(new com.sstu.war.geometry.Dot(3, 5), 3);
////        square163_1.setSquare(0, 2, 4);
////        square163_1.getSquare();
//        com.sstu.war.geometry.Square square163_2 = new com.sstu.war.geometry.Square(new com.sstu.war.geometry.Dot(9, 0), 5);
//        square163_2.setSquare(1, 2, 4);
//        square163_2.getSquare();
//        System.out.println("\n");
//    }
//
//    public static void task1_6_4(){
//        System.out.println("1.6.4");
//        com.sstu.mathematic.Fraction fraction164_1 = new com.sstu.mathematic.Fraction(3, 6);
//        System.out.println(fraction164_1);
////        fraction164_1.numerator = 4; - нельзя изменить
////        com.sstu.mathematic.Fraction fraction164_2 = new com.sstu.mathematic.Fraction(5, -6); - нельзя сделать отрицательный знаменатель
//        System.out.println("\n");
//    }
//
//    public static void task1_6_5(){
//        System.out.println("1.6.5");
//        com.sstu.war.Gun gun2 = new com.sstu.war.Gun(3, 7);
//        gun2.fire();
//        gun2.fire();
//        gun2.fire();
//        gun2.fire();
//        gun2.fire();
//        gun2.reloading(8);
//        gun2.fire();
//        gun2.fire();
//        gun2.unloading();
//        gun2.fire();
//        System.out.println("\n");
//    }
//
//    public static void task1_6_6(){
//        System.out.println("1.6.6");
//        com.sstu.war.geometry.Dot dot166_1 = new com.sstu.war.geometry.Dot(0, 0);
//        com.sstu.war.geometry.Dot dot166_2 = new com.sstu.war.geometry.Dot(5, 5);
//        com.sstu.war.geometry.Dot dot166_3 = new com.sstu.war.geometry.Dot(-10, -10);
//
//        com.sstu.war.geometry.Line line166_1 = new com.sstu.war.geometry.Line(dot166_1, dot166_2);
//        com.sstu.war.geometry.Line line166_2 = new com.sstu.war.geometry.Line(dot166_2, dot166_3);
//
//        dot166_2.x = 20;
//        dot166_2.y = -20;
//        System.out.println("Line1: " + line166_1);
//        System.out.println("Line2: " + line166_2);
//
//        com.sstu.war.geometry.Dot dotGetter1 = line166_1.getStart();
//        dotGetter1.x = 100;
//        System.out.println("Line1 после применения геттера: " + line166_1);
//        System.out.println("\n");
//    }
//
//    public static void task1_6_7(){
//        System.out.println("1.6.7");
//        com.sstu.people.Human human167_1 = new com.sstu.people.Human(new com.sstu.people.Name("Александр", "Сидоров"));
//        com.sstu.people.Human human167_2 = new com.sstu.people.Human(human167_1, "Ярослав");
//        com.sstu.people.Human human167_3 = new com.sstu.people.Human("Антон");
////        human167_2.father = human167_3;  - выведет исключение
//        System.out.println(human167_2);
//        System.out.println("\n");
//    }
//
//    public static void task1_6_8(){
//        System.out.println("1.6.8");
//        com.sstu.students.Student student3 = new com.sstu.students.Student("Саша", 4, 5, 2);
////        com.sstu.students.Student student4 = new com.sstu.students.Student("Коля", 1, 0, 10);
//        System.out.println(Arrays.toString(student3.getGrades()));
////        System.out.println(student4);
//        System.out.println("\n");
//    }
//
//    public static void task1_6_9(){
//        System.out.println("1.6.9");
//        com.sstu.cities.City Aa = new com.sstu.cities.City("A");
//        com.sstu.cities.City Cc = new com.sstu.cities.City("C");
//        com.sstu.cities.City Dd = new com.sstu.cities.City("D");
//        com.sstu.cities.City Bb = new com.sstu.cities.City("B");
//
//        Aa.addPath(Bb, 5);
//        Aa.addPath(Dd, 6);
//        System.out.println("Для А обновили пути:\n" + Aa);
//
//        Aa.addPath(Bb, 3);
//        System.out.println("Снова для А обновили путь:\n " + Aa);
//
//        Bb.addPath(Aa, 3);
//        Dd.addPath(Aa, 6);
//        System.out.println("Добавили обратные пути:\n" + Bb);
//
//        Aa.removePath(Dd);
//        System.out.println("Для А удалили один путь:\n " + Aa);
//
//        int cost = Aa.getPathCost(Bb);
//        System.out.println("Стоимость пути A-B: " + cost);
//        System.out.println("\n");
//    }
//
//    public static void task1_6_10(){
//        com.sstu.works.Department itDepartment = new com.sstu.works.Department("IT");
//
//        com.sstu.works.Employee boss = itDepartment.addBoss("Петров");
//        System.out.println(boss);
//
//        itDepartment.addEmployee(new com.sstu.works.Employee("Иванов"));
//        itDepartment.addEmployee(new com.sstu.works.Employee("Сидоров"));
//
//        System.out.println("Все сотрудники отдела:");
//        for (com.sstu.works.Employee emp : itDepartment.getEmployees()) {
//            System.out.println("- " + emp.getName());
//        }
//
//        com.sstu.works.Employee ivanov = itDepartment.getEmployees().get(1); // Иванов
//        itDepartment.setBoss(ivanov);
//        System.out.println(ivanov);
//
//        com.sstu.works.Department hrDepartment = new com.sstu.works.Department("HR");
//        com.sstu.works.Employee hrEmployee = new com.sstu.works.Employee("Козлов");
//        hrDepartment.addEmployee(hrEmployee);
//
//        itDepartment.setBoss(hrEmployee);
//        System.out.println(hrEmployee);
//        System.out.println("\n");
//    }

    public static void classWork02_10_25(){
        //        Банковский аккаунт
        BankAccount bankAccount = new BankAccount("fff", "01.01.2000", "1234 123456");
        bankAccount.addAccount(100, 1);
        bankAccount.addAccount(300, 6);
        bankAccount.addAccount(1000, 3);
        bankAccount.addAccount(1090, 5);
        System.out.println(Arrays.toString(bankAccount.getAccounts()));
        bankAccount.outMoney(6);
        bankAccount.addAccount(1000, 3);
        System.out.println(Arrays.toString(bankAccount.getAccounts()));
//        com.sstu.banks.BankAccount bankAccount1 = new com.sstu.banks.BankAccount("", "01.01.2000", "1234 123456");
    }

    public static void task2_1_1(){
//        class NewFraction extends com.sstu.mathematic.Fraction{
//            public com.sstu.mathematic.Fraction(int numerator, int denominator){
//                if (denominator <= 0){
//                    throw new IllegalArgumentException("denominator must be positive");
//                }
//                int divisor = greatestCommonDivisor(Math.abs(numerator), Math.abs(denominator));
//                this.numerator = numerator / divisor;
//                this.denominator = denominator / divisor;
//            }
//        }
    }

//    public static void task2_1_2(){
//        Dot dot1 = new Dot(3, 4);
//        Dot dot2 = new Dot(3, -4);
//        Dot dot3 = new Dot(6, -4);
//        Dot dot4 = new Dot(6, 4);
//        ClosedPolyline spline1 = new ClosedPolyline(dot1, dot2, dot3, dot4);
//        System.out.println(spline1.splineLength());
//    }

    public static void task2_1_3(){
        // Создаем инновационные города
        InnovativeCity A = new InnovativeCity("A");
        InnovativeCity B = new InnovativeCity("B");
        InnovativeCity C = new InnovativeCity("C");

        System.out.println("До добавления путей:");
        System.out.println(A);
        System.out.println(B);

        // Добавляем путь - автоматически создается обратный
        A.addPath(B, 700);

        System.out.println("\nПосле добавления пути A-B:");
        System.out.println("A:");
        System.out.println(A);
        System.out.println("B:");
        System.out.println(B);

        // Добавляем еще один путь
        A.addPath(C, 800);

        System.out.println("\nПосле добавления пути A-C:");
        System.out.println("A:");
        System.out.println(A);
        System.out.println("C:");
        System.out.println(C);

        // Обновляем стоимость - обновляются оба пути
        A.addPath(B, 650);

        System.out.println("\nПосле обновления стоимости A-B:");
        System.out.println("A:");
        System.out.println(A);
        System.out.println("B:");
        System.out.println(B);

        // Удаляем путь - удаляются оба направления
        A.removeBidirectionalPath(C);

        System.out.println("\nПосле удаления пути A-C:");
        System.out.println("A:");
        System.out.println(A);
        System.out.println("C:");
        System.out.println(C);
    }

//    public static void task2_1_4(){
//        MachineGun gun1 = new MachineGun();
//        MachineGun gun2 = new MachineGun(20);
//        MachineGun gun3 = new MachineGun(40, 10);
//        System.out.println("Gun1:\n");
//        gun1.patrons = 30;
//        gun1.fire();
//        System.out.println("Gun2:\n");
//        gun2.patrons = 10;
//        gun2.fire(3);
//        System.out.println("Gun3:\n");
//        gun3.patrons = 20;
//        gun3.fire(3);
//    }

//    public static void task2_1_5(){
//        ThreeCoordinatesDot dot1 = new ThreeCoordinatesDot(5, 3);
//        ThreeCoordinatesDot dot2 = new ThreeCoordinatesDot(4, -8, 10);
//        System.out.println(dot1);
//        System.out.println(dot2);
//    }

    public static void task2_2_1(){
        Gun gun1 = new Gun(20);
        Gun gun2 = new Gun(4, 15);
        System.out.println("Пистолет 1, патронов: " + gun1.patrons());
        gun1.fire();
        gun1.fire();
        gun1.fire();
        System.out.println("Вынимаем патрон: " + gun1.getPatrons());
        System.out.println("Вынимаем патрон: " + gun1.getPatrons());
        System.out.println("Вынимаем патрон: " + gun1.getPatrons());
        gun1.fire();

        System.out.println("Пистолет 2, патронов: " + gun2.patrons());
        gun2.fire();
        System.out.println("Возвращено патронов при разрядке: " + gun2.unloading());
        gun2.fire();
        System.out.println("Возвращено патронов: " + gun2.load(20));
        gun2.fire();
        gun2.fire();
        gun2.fire();
        gun2.fire();
        gun2.fire();
        System.out.println("Всего патронов: " + gun2.patrons());
    }

    public static void task2_2_2(){
        Fraction fraction1 = new Fraction(4, 3);
        Fraction fraction2 = new Fraction(2, 3);
        Fraction fraction3 = new Fraction(56473957, 5768);
        System.out.println(fraction1.intValue());
        System.out.println(fraction3.longValue());
        System.out.println(fraction2.floatValue());
        System.out.println(fraction2.doubleValue());
    }

    public static void task2_2_3(){
        Sparrow sparrow = new Sparrow();
        Cuckoo cuckoo = new Cuckoo();
        Parrot parrot = new Parrot("Тралалеро-тралала");
        sparrow.sing();
        cuckoo.sing();
        parrot.sing();
    }

//    public static void task2_2_4(){
//        Dot dotCircle = new Dot(0, 5);
//        Dot dotSquare = new Dot(10, 5);
//        Dot dotTriangle1 = new Dot(4, 8);
//        Dot dotTriangle2 = new Dot(-3, 0);
//        Dot dotTriangle3 = new Dot(6, -9);
//        Dot dotRectangle = new Dot(1, 4);
//
//        Circle circle = new Circle(dotCircle, 4);
//        NewSquare square = new NewSquare(dotSquare, 5);
//        Triangle triangle = new Triangle(dotTriangle1, dotTriangle2, dotTriangle3);
//        Rectangle rectangle = new Rectangle(dotRectangle, 4, 7);
//
//        System.out.println(circle.getArea());
//        System.out.println(square.getArea());
//        System.out.println(triangle.getArea());
//        System.out.println(rectangle.getArea());
//
//    }
//
//    public static void task2_2_5(){
//        AbstractDot point1 = DotWithCharacteristics.wrap(new Dot(3, 0))
//                .withColor("красный");
//        System.out.println(point1.getDescription());
//
//        AbstractDot point2 = DotWithCharacteristics.wrap(new Dot(-3, 10))
//                .withColor("синий")
//                .withSize(20);
//        System.out.println(point2.getDescription());
//    }

    public static void task2_3_1(){
        double res1 = Calculator.sum(
                new IntegerWrapper(2),
                new Fraction(3, 5),
                new DoubleWrapper(2.3)
        );
        System.out.println(res1);
        double res2 = Calculator.sum(
                new DoubleWrapper(3.6),
                new Fraction(49, 12),
                new IntegerWrapper(3),
                new Fraction(3, 2)
        );
        double res3 = Calculator.sum(
                new Fraction(1, 3),
                new IntegerWrapper(1)
        );
        System.out.println(res2);
        System.out.println(res3);
    }

    public static void task2_3_2(){
        Sparrow sparrow1 = new Sparrow();
        Sparrow sparrow2 = new Sparrow();
        Cuckoo cuckoo1 = new Cuckoo();
        Cuckoo cuckoo2 = new Cuckoo();
        Parrot parrot1 = new Parrot("Тралалело-тралала");
        Parrot parrot2 = new Parrot("Трипи-тропи, тропа-трипа");
        Parrot parrot3 = new Parrot("Балерина-капучина!");

        String birdsSongs = BirdsMarket.singingSongs(parrot1, sparrow1, cuckoo1, parrot2, cuckoo2, sparrow2, parrot3);
        System.out.println(birdsSongs);
    }

//    public static void task2_3_3(){
//        Circle circle = new Circle(new Dot(0,0), 4);
//        NewSquare square = new NewSquare(new Dot(5, 10), 3);
//        Rectangle rectangle = new Rectangle(new Dot(3, -10), 3, 5);
//        Triangle triangle = new Triangle(new Dot(6, 3), new Dot(2, -4), new Dot(0, 6));
//
//        double res = AreasCalculator.sum(circle, square, rectangle, triangle);
//        System.out.println(res);
//    }

    public static void task2_3_4(){
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Кузя");
        Cat cat3 = new Cat("Маркиза");
        Student student = new Student("Василий", 5, 4, 3, 5);
        WildCat wildCat1 = new WildCat("Тигр");
        WildCat wildCat2 = new WildCat("Рысь");

        CatUtils.makeAllMeow(cat2, wildCat2, cat3, cat1, student, wildCat1);

    }

//    public static void task2_3_5(){
//        Line line1 = new Line(2, 5, -10, 0);
//        Line line2 = new Line(new Dot(6, -8), new Dot(1, 5));
//        Dot dot1 = new Dot(4, 9);
//        Dot dot2 = new Dot(-9, -5);
//        Dot dot3 = new Dot(0, 5);
//        Dot dot4 = new Dot(-3, 2);
//        Dot dot5 = new Dot(0, 0);
//        BrokenLine brokenLine = new BrokenLine(dot1, dot2, dot3, dot4, dot5);
//
//        double sumSizes = AllSizes.sumAllSizes(line1, line2, brokenLine);
//        System.out.println(sumSizes);
//    }
//
//    public static void task2_3_6(){
//        Square square1 = new Square(0, 5, 5);
//        System.out.println(square1.polyline().splineLength());
//    }

//    public static void task2_3_7(){
//        NewSquare square = new NewSquare(new Dot(3, 4), 1);
//        BrokenLine brokenLine1 = new BrokenLine(new Dot(6, 7), new Dot(0, 4), new Dot(-8, 7), new Dot(1, 5), new Dot(-3, -1));
//        Triangle triangle = new Triangle(new Dot(1, 8), new Dot(5, 0), new Dot(-3, 1));
//        Rectangle rectangle = new Rectangle(new Dot(10, -5), 10, 5);
//        BrokenLine bigBrokenLine = PolylineSummary.sumBrokable(square, brokenLine1, triangle, rectangle);
//        System.out.println(bigBrokenLine);
//    }

//    public static void task2_3_8(){
//        Gun gun = new Gun(7, 10);
//        MachineGun machineGun = new MachineGun(40, 20);
//        machineGun.patrons = 10;
//        Shooter shooter1 = new Shooter("Петя");
//        Shooter shooter2 = new Shooter("Вася");
//        Shooter shooter3 = new Shooter("Саша");
//        shooter2.setWeapon(gun);
//        shooter3.setWeapon(machineGun);
//        System.out.println("Стреляет " + shooter1.getName() + ": ");
//        shooter1.fire();
//        System.out.println("Стреляет " + shooter2.getName() + ": ");
//        shooter2.fire();
//        System.out.println("Стреляет " + shooter3.getName() + ": ");
//        shooter3.fire();
//
//    }

    public static void task2_3_9(){
        Student student1 = new Student("Вася", grade -> grade == 1 || grade == 0, 0, 1, 1, 1, 0, 0, 1);
        Student student2 = new Student("Петя", grade -> grade % 2 == 0, 2, 6, 6, 4, 8, 14);
        System.out.println(student1);
        System.out.println(student2);
    }

    public static void task3_1_3(){
        BigInteger bi = new BigInteger("12345678912345678912");
        double sum = Calculator.sum(new IntegerWrapper(7), new Fraction(11, 3), new DoubleWrapper(3.21), new BigIntegerWrapper(bi));
        System.out.println(sum);
    }
    public static void task3_1_4(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        String strX = scanner.nextLine();
        System.out.println("Введите второе число:");
        String strY = scanner.nextLine();
        double newPow = NewPow.powXtoY(strX, strY);
        System.out.println(strX + " в степени " + strY + " равно " + newPow);

    }

    public static void task3_1_5(){
        Dot dot = new Dot(4, -6);
        Point point = new Point();
        point.x = 1;
        point.y = 0;
        System.out.println(dot);
        System.out.println(point);
    }

    public static void task4_1_1(){
        Student student = new Student("Вася", grade -> grade % 2 == 0, 2, 5, 6, 8, 0);
        System.out.println(student);

    }

    public static void task4_1_4(){
        Connection connection = new Connection("032:134:52:0");
        System.out.println(connection);
        Connection connection1 = new Connection("56:255:8:0");
        connection1.closeConnection();
        System.out.println(connection1);
    }

    public static void task4_2_1(){
        TestConnect.readData();
    }

    public static void task4_2_2(){
        double result = DividedParsedStrings.dividedStrings("64", "8", "2");
        System.out.println(result);
    }

    public static void task4_2_3(){
        Student student1 = new Student("N", grade -> grade <= 5, 2, 3, 4, 5);
        Student student2 = new Student("T", grade -> grade >= 5, 7, 8, 5);
        Student student3 = new Student("H", grade -> grade != 5, 7, 8, 4, 1);
        GradeGenerator gg = new GradeGenerator();
        gg.generateGrades(student1, student2, student3);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }

    public static void task4_2_4(){
        ExampleConnector ec = new ExampleConnector();
        Connection connection = new Connection("8747348");
        ec.makeConnect(connection);
    }

    public static void task5_1_1(){
        Fraction fraction1 = new Fraction(1, 3);
        Fraction fraction2 = new Fraction(1, 3);
        Fraction fraction3 = new Fraction(1, 5);
        System.out.println(fraction1.equals(fraction2));
        System.out.println(fraction1.equals(fraction3));
    }

    public static void task5_1_2(){
        Dot dot1 = new Dot(4, 5);
        Dot dot2 = new Dot(4, 5);
        Dot dot3 = new Dot(4, 7);
        System.out.println(dot1.equals(dot2));
        System.out.println(dot1.equals(dot3));
    }

    public static void task5_1_3(){
        Line line1 = new Line(new Dot(1, 3), new Dot(4,5 ));
        Line line2 = new Line(new Dot(1, 3), new Dot(4,5 ));
        Line line3 = new Line(new Dot(4, 5), new Dot(1,3 ));
        Line line4 = new Line(new Dot(5, 3), new Dot(8,5 ));
        System.out.println(line1.equals(line2));
        System.out.println(line1.equals(line3));
        System.out.println(line1.equals(line4));
    }

    public static void task5_1_4(){
        BrokenLine brokenLine1 = new BrokenLine(new Dot(1,2), new Dot(3, 4), new Dot(7, 8));
        ClosedPolyline closedPolyline = new ClosedPolyline(new Dot(1, 2), new Dot(3, 4), new Dot(7, 8));
        BrokenLine brokenLine2 = new BrokenLine(new Dot(1, 2), new Dot(3, 4), new Dot(7, 8), new Dot(1, 2));
        BrokenLine brokenLine3 = new BrokenLine(new Dot(1,2), new Dot(3, 4), new Dot(7, 8));
        System.out.println(brokenLine1.equals(brokenLine2));
        System.out.println(brokenLine2.equals(closedPolyline));
        System.out.println(closedPolyline.equals(brokenLine2));
        System.out.println(brokenLine1.equals(brokenLine3));
    }

    public static void task5_1_5(){
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");

        InnovativeCity AInnovative = new InnovativeCity("A");
        InnovativeCity BInnovative = new InnovativeCity("B");

        A.addPath(B, 100);
        A.addPath(C, 200);

        City A2 = new City("Москва");
        A2.addPath(B, 150); // разная стоимость
        A2.addPath(C, 250);

        System.out.println("A.equals(A2): " + A.equals(A2));

        AInnovative.addPath(B, 100);
        AInnovative.addPath(C, 200);

        System.out.println("AInnovative.equals(A): " + AInnovative.equals(A));
        System.out.println("A.equals(AInnovative): " + A.equals(AInnovative));
    }

    public static void task5_1_6(){
        Student student1 = new Student("Петя", 1, 2, 3, 4, 5);
        Student student2 = new Student("Петя", 1, 4, 5, 3, 2);
        Student student3 = new Student("Петя", 7, 2, 3, 4, 5);
        System.out.println(student1.equals(student2));
        System.out.println(student1.equals(student3));
    }

    public static void task5_2_1(){
        Fraction fraction1 = new Fraction(1, 5);
        Fraction fraction2 = fraction1.clone();
        System.out.println(fraction1);
        System.out.println(fraction2);
    }

    public static void task5_2_2(){
        Dot dot1 = new Dot(2, 7);
        Dot dot2 = dot1.clone();
        System.out.println(dot1);
        System.out.println(dot2);
    }

    public static void task5_2_3(){
        Line line1 = new Line(new Dot(1, 4), new Dot(5, -3));
        Line line2 = line1.clone();
        System.out.println(line1);
        System.out.println(line2);
    }

}
