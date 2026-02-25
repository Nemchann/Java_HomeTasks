package com.nemchann.util;

import com.nemchann.animals.*;
import com.nemchann.banks.BankAccount;
import com.nemchann.converter.Converter;
import com.nemchann.converter.TextConverter;
import com.nemchann.data_bases.DataBase;
import com.nemchann.data_bases.DatabaseConnection;
import com.nemchann.data_bases.Db;
import com.nemchann.data_bases.Point;
import com.nemchann.fight_club.CombinationManager;
import com.nemchann.fight_club.Karateka;
import com.nemchann.fight_club.KickCommand;
import com.nemchann.geometry.*;
import com.nemchann.mathematic.*;
import com.nemchann.storages.Box;
import com.nemchann.storages.Dot3DPutter;
import com.nemchann.storages.MaximumFinder;
import com.nemchann.storages.Storage;
import com.nemchann.structures.Stack;
import com.nemchann.students.Student;
import com.nemchann.temperatures.Temperature;
import com.nemchann.to_apply.Transformer;
import com.nemchann.to_collect.Collector;
import com.nemchann.to_concise.ReducerUtils;
import com.nemchann.to_filter.Filter;
import com.nemchann.people.Name;
import com.nemchann.stream.Stream;
import com.nemchann.declaration.*;
import com.nemchann.doorman.*;
import com.nemchann.traffic_lights.*;
import com.nemchann.fields.*;
import com.nemchann.entity.*;
import com.nemchann.validation.*;
import com.nemchann.io.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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

  //  public static void task2_1_1(){
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
 //   }

//    public static void task2_1_2(){
//        Dot dot1 = new Dot(3, 4);
//        Dot dot2 = new Dot(3, -4);
//        Dot dot3 = new Dot(6, -4);
//        Dot dot4 = new Dot(6, 4);
//        ClosedPolyline spline1 = new ClosedPolyline(dot1, dot2, dot3, dot4);
//        System.out.println(spline1.splineLength());
//    }

//    public static void task2_1_3(){
//        // Создаем инновационные города
//        InnovativeCity A = new InnovativeCity("A");
//        InnovativeCity B = new InnovativeCity("B");
//        InnovativeCity C = new InnovativeCity("C");
//
//        System.out.println("До добавления путей:");
//        System.out.println(A);
//        System.out.println(B);
//
//        // Добавляем путь - автоматически создается обратный
//        A.addPath(B, 700);
//
//        System.out.println("\nПосле добавления пути A-B:");
//        System.out.println("A:");
//        System.out.println(A);
//        System.out.println("B:");
//        System.out.println(B);
//
//        // Добавляем еще один путь
//        A.addPath(C, 800);
//
//        System.out.println("\nПосле добавления пути A-C:");
//        System.out.println("A:");
//        System.out.println(A);
//        System.out.println("C:");
//        System.out.println(C);
//
//        // Обновляем стоимость - обновляются оба пути
//        A.addPath(B, 650);
//
//        System.out.println("\nПосле обновления стоимости A-B:");
//        System.out.println("A:");
//        System.out.println(A);
//        System.out.println("B:");
//        System.out.println(B);
//
//        // Удаляем путь - удаляются оба направления
//        A.removeBidirectionalPath(C);
//
//        System.out.println("\nПосле удаления пути A-C:");
//        System.out.println("A:");
//        System.out.println(A);
//        System.out.println("C:");
//        System.out.println(C);
//    }

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

//    public static void task2_2_1(){
//        Gun gun1 = new Gun(20);
//        Gun gun2 = new Gun(4, 15);
//        System.out.println("Пистолет 1, патронов: " + gun1.patrons());
//        gun1.fire();
//        gun1.fire();
//        gun1.fire();
//        System.out.println("Вынимаем патрон: " + gun1.getPatrons());
//        System.out.println("Вынимаем патрон: " + gun1.getPatrons());
//        System.out.println("Вынимаем патрон: " + gun1.getPatrons());
//        gun1.fire();
//
//        System.out.println("Пистолет 2, патронов: " + gun2.patrons());
//        gun2.fire();
//        System.out.println("Возвращено патронов при разрядке: " + gun2.unloading());
//        gun2.fire();
//        System.out.println("Возвращено патронов: " + gun2.load(20));
//        gun2.fire();
//        gun2.fire();
//        gun2.fire();
//        gun2.fire();
//        gun2.fire();
//        System.out.println("Всего патронов: " + gun2.patrons());
//    }
//
//    public static void task2_2_2(){
//        Fraction fraction1 = new Fraction(4, 3);
//        Fraction fraction2 = new Fraction(2, 3);
//        Fraction fraction3 = new Fraction(56473957, 5768);
//        System.out.println(fraction1.intValue());
//        System.out.println(fraction3.longValue());
//        System.out.println(fraction2.floatValue());
//        System.out.println(fraction2.doubleValue());
//    }
//
//    public static void task2_2_3(){
//        Sparrow sparrow = new Sparrow();
//        Cuckoo cuckoo = new Cuckoo();
//        Parrot parrot = new Parrot("Тралалеро-тралала");
//        sparrow.sing();
//        cuckoo.sing();
//        parrot.sing();
//    }

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

//    public static void task2_3_1(){
//        double res1 = Calculator.sum(
//                new IntegerWrapper(2),
//                new Fraction(3, 5),
//                new DoubleWrapper(2.3)
//        );
//        System.out.println(res1);
//        double res2 = Calculator.sum(
//                new DoubleWrapper(3.6),
//                new Fraction(49, 12),
//                new IntegerWrapper(3),
//                new Fraction(3, 2)
//        );
//        double res3 = Calculator.sum(
//                new Fraction(1, 3),
//                new IntegerWrapper(1)
//        );
//        System.out.println(res2);
//        System.out.println(res3);
//    }
//
//    public static void task2_3_2(){
//        Sparrow sparrow1 = new Sparrow();
//        Sparrow sparrow2 = new Sparrow();
//        Cuckoo cuckoo1 = new Cuckoo();
//        Cuckoo cuckoo2 = new Cuckoo();
//        Parrot parrot1 = new Parrot("Тралалело-тралала");
//        Parrot parrot2 = new Parrot("Трипи-тропи, тропа-трипа");
//        Parrot parrot3 = new Parrot("Балерина-капучина!");
//
//        String birdsSongs = BirdsMarket.singingSongs(parrot1, sparrow1, cuckoo1, parrot2, cuckoo2, sparrow2, parrot3);
//        System.out.println(birdsSongs);
//    }

//    public static void task2_3_3(){
//        Circle circle = new Circle(new Dot(0,0), 4);
//        NewSquare square = new NewSquare(new Dot(5, 10), 3);
//        Rectangle rectangle = new Rectangle(new Dot(3, -10), 3, 5);
//        Triangle triangle = new Triangle(new Dot(6, 3), new Dot(2, -4), new Dot(0, 6));
//
//        double res = AreasCalculator.sum(circle, square, rectangle, triangle);
//        System.out.println(res);
//    }

//    public static void task2_3_4(){
//        Cat cat1 = new Cat("Барсик");
//        Cat cat2 = new Cat("Кузя");
//        Cat cat3 = new Cat("Маркиза");
//        Student student = new Student("Василий", 5, 4, 3, 5);
//        WildCat wildCat1 = new WildCat("Тигр");
//        WildCat wildCat2 = new WildCat("Рысь");
//
//        CatUtils.makeAllMeow(cat2, wildCat2, cat3, cat1, student, wildCat1);
//
//    }

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

//    public static void task2_3_9(){
//        Student student1 = new Student("Вася", grade -> grade == 1 || grade == 0, 0, 1, 1, 1, 0, 0, 1);
//        Student student2 = new Student("Петя", grade -> grade % 2 == 0, 2, 6, 6, 4, 8, 14);
//        System.out.println(student1);
//        System.out.println(student2);
//    }
//
//    public static void task3_1_3(){
//        BigInteger bi = new BigInteger("12345678912345678912");
//        double sum = Calculator.sum(new IntegerWrapper(7), new Fraction(11, 3), new DoubleWrapper(3.21), new BigIntegerWrapper(bi));
//        System.out.println(sum);
//    }
//    public static void task3_1_4(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите первое число:");
//        String strX = scanner.nextLine();
//        System.out.println("Введите второе число:");
//        String strY = scanner.nextLine();
//        double newPow = NewPow.powXtoY(strX, strY);
//        System.out.println(strX + " в степени " + strY + " равно " + newPow);
//
//    }
//
//    public static void task3_1_5(){
//        Dot dot = new Dot(4, -6);
//        Point point = new Point();
//        point.x = 1;
//        point.y = 0;
//        System.out.println(dot);
//        System.out.println(point);
//    }
//
//    public static void task4_1_1(){
//        Student student = new Student("Вася", grade -> grade % 2 == 0, 2, 5, 6, 8, 0);
//        System.out.println(student);
//
//    }
//
//    public static void task4_1_4(){
//        Connection connection = new Connection("032:134:52:0");
//        System.out.println(connection);
//        Connection connection1 = new Connection("56:255:8:0");
//        connection1.closeConnection();
//        System.out.println(connection1);
//    }
//
//    public static void task4_2_1(){
//        TestConnect.readData();
//    }
//
//    public static void task4_2_2(){
//        double result = DividedParsedStrings.dividedStrings("64", "8", "2");
//        System.out.println(result);
//    }
//
//    public static void task4_2_3(){
//        Student student1 = new Student("N", grade -> grade <= 5, 2, 3, 4, 5);
//        Student student2 = new Student("T", grade -> grade >= 5, 7, 8, 5);
//        Student student3 = new Student("H", grade -> grade != 5, 7, 8, 4, 1);
//        GradeGenerator gg = new GradeGenerator();
//        gg.generateGrades(student1, student2, student3);
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);
//    }
//
//    public static void task4_2_4(){
//        ExampleConnector ec = new ExampleConnector();
//        Connection connection = new Connection("8747348");
//        ec.makeConnect(connection);
//    }

//    public static void task5_1_1(){
//        Fraction fraction1 = new Fraction(1, 3);
//        Fraction fraction2 = new Fraction(1, 3);
//        Fraction fraction3 = new Fraction(1, 5);
//        System.out.println(fraction1.equals(fraction2));
//        System.out.println(fraction1.equals(fraction3));
//    }

//    public static void task5_1_2(){
//        Dot dot1 = new Dot(4, 5);
//        Dot dot2 = new Dot(4, 5);
//        Dot dot3 = new Dot(4, 7);
//        System.out.println(dot1.equals(dot2));
//        System.out.println(dot1.equals(dot3));
//    }

//    public static void task5_1_3(){
//        Line line1 = new Line(new Dot(1, 3), new Dot(4,5 ));
//        Line line2 = new Line(new Dot(1, 3), new Dot(4,5 ));
//        Line line3 = new Line(new Dot(4, 5), new Dot(1,3 ));
//        Line line4 = new Line(new Dot(5, 3), new Dot(8,5 ));
//        System.out.println(line1.equals(line2));
//        System.out.println(line1.equals(line3));
//        System.out.println(line1.equals(line4));
//        System.out.println(line1.hashCode());
//        System.out.println(line2.hashCode());
//        System.out.println(line3.hashCode());
//        System.out.println(line4.hashCode());
//    }

//    public static void task5_1_4(){
//        BrokenLine brokenLine1 = new BrokenLine(new Dot(1,2), new Dot(3, 4), new Dot(7, 8));
//        ClosedPolyline closedPolyline = new ClosedPolyline(new Dot(1, 2), new Dot(3, 4), new Dot(7, 8));
//        BrokenLine brokenLine2 = new BrokenLine(new Dot(1, 2), new Dot(3, 4), new Dot(7, 8), new Dot(1, 2));
//        BrokenLine brokenLine3 = new BrokenLine(new Dot(1,2), new Dot(3, 4), new Dot(7, 8));
//        System.out.println(brokenLine1.equals(brokenLine2));
//        System.out.println(brokenLine2.equals(closedPolyline));
//        System.out.println(closedPolyline.equals(brokenLine2));
//        System.out.println(brokenLine1.equals(brokenLine3));
//    }

//    public static void task5_1_5(){
//        City A = new City("A");
//        City B = new City("B");
//        City C = new City("C");
//
//        InnovativeCity AInnovative = new InnovativeCity("A");
//        InnovativeCity BInnovative = new InnovativeCity("B");
//
//        A.addPath(B, 100);
//        A.addPath(C, 200);
//
//        City A2 = new City("Москва");
//        A2.addPath(B, 150); // разная стоимость
//        A2.addPath(C, 250);
//
//        System.out.println("A.equals(A2): " + A.equals(A2));
//
//        AInnovative.addPath(B, 100);
//        AInnovative.addPath(C, 200);
//
//        System.out.println("AInnovative.equals(A): " + AInnovative.equals(A));
//        System.out.println("A.equals(AInnovative): " + A.equals(AInnovative));
//    }
//
//    public static void task5_1_6(){
//        Student student1 = new Student("Петя", 1, 2, 3, 4, 5);
//        Student student2 = new Student("Петя", 1, 4, 5, 3, 2);
//        Student student3 = new Student("Петя", 7, 2, 3, 4, 5);
//        System.out.println(student1.equals(student2));
//        System.out.println(student1.equals(student3));
//    }
//
//    public static void task5_2_1(){
//        Fraction fraction1 = new Fraction(1, 5);
//        Fraction fraction2 = fraction1.clone();
//        System.out.println(fraction1);
//        System.out.println(fraction2);
//    }
//
//    public static void task5_2_2(){
//        Dot dot1 = new Dot(2, 7);
//        Dot dot2 = dot1.clone();
//        System.out.println(dot1);
//        System.out.println(dot2);
//    }
//
//    public static void task5_2_3(){
//        Line line1 = new Line(new Dot(1, 4), new Dot(5, -3));
//        Line line2 = line1.clone();
//        System.out.println(line1);
//        System.out.println(line2);
//    }

    public static void task6_1_1(){
        Box<Integer> box = new Box<>();
        box.putObj(3);
        System.out.println(box);
        System.out.println(box.getObj());
        box.takeObj();
        System.out.println(box);
        box.putObj(7);
        System.out.println(box);
        box.putObj(99);
        System.out.println(box);
    }

//    public static void task6_1_2(){
//        Storage<Integer> integerStorage1 = new Storage<>(null, 0);
//        Storage<Integer> integerStorage2 = new Storage<>(99, -1);
//        Storage<String> integerStorage3 = new Storage<String>(null, "default");
//        Storage<String> integerStorage4 = new Storage<String>("hello world", "hello");
//
//        System.out.println(integerStorage1.getObj());
//        System.out.println(integerStorage2.getObj());
//        System.out.println(integerStorage3.getObj());
//        System.out.println(integerStorage4.getObj());
//    }

    public static void task6_1_4(){
        Student student1 = new Student("Vasya", grade -> grade >= 2 && grade <= 5, 4, 5, 5, 4, 3, 3);
        Student student2 = new Student("Sasha", grade -> grade >= 2 && grade <= 5, 4, 5, 5, 4, 3, 3);
        Student student3 = new Student("Petya", grade -> grade >= 2 && grade <= 5, 2, 4, 3, 3, 3, 2);
        Student student4 = new Student("Kolya", grade -> grade >= 2 && grade <= 5, 4, 5, 5, 4, 5, 5);
        System.out.println(student1.compareTo(student2));
        System.out.println(student1.compareTo(student3));
        System.out.println(student1.compareTo(student4));
    }

    public static void task6_1_5(){
        Dot dot1 = DotGenerator.create2DDot(1, 4);
        Dot dot2 = DotGenerator.create2DDot(9, -4);
        Line<Dot> line1 = new Line<>(dot1, dot2);
        ThreeCoordinatesDot dot3 = DotGenerator.create3DDot(3, 9, 2);
        ThreeCoordinatesDot dot4 = DotGenerator.create3DDot(-5, 1, 8);
        Line<ThreeCoordinatesDot> line2 = new Line<>(dot3, dot4);
        System.out.println(line1);
        System.out.println(line2);

    }

    public static void task6_1_6(){
        Stack<String> stack = new Stack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");
        System.out.println(stack.peak());
        System.out.println(stack.pop());
        System.out.println(stack.peak());
    }

    public static void task6_2_1(){
        Dot dot1 = DotGenerator.create2DDot(5, 1);
        Dot dot2 = DotGenerator.create2DDot(8, 0);
        Dot dot3 = DotGenerator.create2DDot(-7, 5);
        Line<Dot> line = new Line<>(dot1, dot2);
        Line<Dot> line1 = new Line<>(dot3, dot2);
        line.moveXto10();
        line1.moveXto10();
        System.out.println(line);
        System.out.println(line1);
    }

    public static void task6_2_2(){
        Box<Double> box1= new Box<>();
        box1.putObj(46.8);
        Box<Integer> box2 = new Box<>();
        box2.putObj(67);
        Box<Short> box3 = new Box<>();
        box3.putObj((short)32);
        Box<Float> box4 = new Box<>();
        box4.putObj(4.5f);

        double doubleValue = MaximumFinder.maximum(box1, box2, box3, box4);
        System.out.println(doubleValue);
    }

    public static void task6_2_3(){
        ThreeCoordinatesDot dot = DotGenerator.create3DDot(1, 7, 9);
        Box<Dot> box= new Box<>();
        Dot3DPutter dPutter = new Dot3DPutter();
        dPutter.setDot(dot);
        dPutter.put3DDot(box);
        System.out.println(box);
    }

    public static void task6_3_1(){
        List<String> strings = List.of("qwerty", "asdfg", "zx");

        List<Integer> lengths = Transformer.transform(strings, str -> str.length());
        System.out.println(lengths + "");

        List<Integer> integers = List.of(1, -3, 7);

        List<Integer> abss = Transformer.transform(integers, integer -> Math.abs(integer));
        System.out.println(abss + "");

        List<int[]> arrays = List.of(
                new int[]{1, 2, 3},
                new int[]{-5, 0, 5},
                new int[]{10, 20, 30, 40});

        List<Integer> maxes = Transformer.transform(arrays, array -> {
            int max = array[0];

            for (int i : array){
                if (i > max) max = i;
            }
            return max;
        });

        System.out.println(maxes + "");
    }

    public static void task6_3_2(){
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<String> filteredStrings = Filter.testing(strings, strs -> strs.length() < 3);
        System.out.println(filteredStrings);

        List<Integer> integers = List.of(1, -3, 7);
        List<Integer> filteredIntegers = Filter.testing(integers, ints -> ints > 0);
        System.out.println(filteredIntegers);

        List<int[]> arrays = List.of(
                new int[]{-1, -2, -3},
                new int[]{-5, 0, 5},
                new int[]{-10, -20, -30, -40});

        List<int[]> filteredArrays = Filter.testing(arrays, arrs ->{
            boolean res = true;
            for (int i : arrs){
                if (i > 0){
                    res = false;
                    break;
                }
            }
            return res;
        });

        for (int[] i : filteredArrays){
            System.out.println(Arrays.toString(i));
        }
    }

    public static void task6_3_3(){
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        String concatenated = ReducerUtils.reduce(strings, "",
                (acc, current) -> acc + current
        );

        System.out.println(concatenated);
        List<String> emptyStrings = List.of();
        String emptyResult = ReducerUtils.reduce(emptyStrings, "",
                (acc, current) -> acc + current
        );
        System.out.println("Пустой список: '" + emptyResult + "'"); // ""

        // Сумма с 0 как identity
        List<Integer> numbers = List.of(1, -3, 7);
        Integer sum = ReducerUtils.reduce(numbers, 0,
                (acc, current) -> acc + current
        );
        System.out.println(sum);

        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );


        Integer totalElements = ReducerUtils.reduce(
                Transformer.transform(listOfLists, List::size),
                0,
                (acc, current) -> acc + current
        );

        System.out.println(totalElements);
    }

    public static void task6_3_4(){
        List<Integer> numbers = List.of(1, -3, 7, -5, 0, 4, -2);

        Collection<List<Integer>> groups = Collector.collect(
                numbers,                       // исходная коллекция
                ArrayList::new,                // создаем новый ArrayList
                List::add,                     // добавляем элемент в список
                num -> num >= 0 ? "positive" : "negative" // классификатор
        );

        System.out.println("Группы чисел: " + groups);

        List<String> strings = List.of("qwerty", "asdfg", "zx", "qw", "hello", "ab");

        Collection<List<String>> stringGroups = Collector.collect(
                strings,
                ArrayList::new,
                List::add,
                String::length  // ключ группировки - длина строки
        );

        System.out.println("Строки по длине: " + stringGroups);

        List<String> duplicates = List.of("qwerty", "asdfg", "qwerty", "qw");

// Используем HashSet для хранения уникальных элементов
        Collection<Set<String>> uniqueGroups = Collector.collect(
                duplicates,
                HashSet::new,           // создаем HashSet (уникальные элементы)
                Set::add,               // добавляем в Set (дубли игнорируются)
                str -> "unique"         // все строки в одну группу
        );

        System.out.println("Уникальные строки: " + uniqueGroups);
    }

//    public static void task7_1_1(){
//        Storage<String> nullableStorage = Storage.createNullable(null, "default");
//        System.out.println(nullableStorage.getObj()); // "default"
//
//        Storage<String> nullableWithValue = Storage.createNullable("hello", "default");
//        System.out.println(nullableWithValue.getObj()); // "hello"
//
//        // 2. Хранилище, запрещающее null (бросает исключение при создании)
//        try {
//            Storage<String> nonNullStorage = Storage.createNonNull(null); // Исключение!
//        } catch (IllegalArgumentException e) {
//            System.out.println("Поймали исключение: " + e.getMessage());
//        }
//
//        Storage<Integer> validStorage = Storage.createNonNull(42);
//        System.out.println(validStorage.getObj()); // 42
//
//
//        // Проверка типа
//        System.out.println(nullableStorage instanceof Storage); // true
//    }

//    public static void task7_1_3(){
//        FractionGenerator fractionGenerator = FractionGenerator.getInstance();
//        Fraction fraction = fractionGenerator.createFraction(3, 7);
//        System.out.println(fraction);
//    }

    public static void task7_1_4(){
        FractionGenerator fractionGenerator = FractionGenerator.getInstance();
        Fraction fraction = fractionGenerator.getFraction(1, 6);
        Fraction fraction1 = fractionGenerator.getFraction(2, 6);
        Fraction fraction2 = fractionGenerator.getFraction(1, 6);
        Fraction fraction3 = fractionGenerator.getFraction(2, 12);

        System.out.println(fraction == fraction1);
        System.out.println(fraction == fraction2);
        System.out.println(fraction == fraction3);

    }

    public static void task7_1_5(){
        Temperature cold = Temperature.getByTemperature(0);
        Temperature warm = Temperature.getByTemperature(20);
        Temperature hot = Temperature.getByTemperature(40);
        Temperature hot1 = Temperature.HOT;

        System.out.println(cold);
        System.out.println(warm);
        System.out.println(hot);
        System.out.println(hot == hot1);
    }

    public static void task7_1_6(){
        DataBase db = new DataBase(3);
        DataBase db2 = new DataBase(7);

        System.out.println("Изначально в БД: " + db.getRecordCount() + " записей");

        // Пытаемся получить подключения
        DatabaseConnection conn1 = db.getConnection();
        DatabaseConnection conn2 = db.getConnection();
        DatabaseConnection conn3 = db.getConnection();
        DatabaseConnection conn4 = db.getConnection(); // null - превышен лимит

        System.out.println("conn4 (превышение лимита): " + conn4); // null

        if (conn1 != null) {
            // Чтение данных
            System.out.println("Запись 0: " + conn1.getRecord(0)); // Record_1
            System.out.println("Запись 100: " + conn1.getRecord(100)); // null

            // Добавление данных
            conn1.addRecord("Новая запись 1");
            System.out.println("Добавлена запись через conn1");

            conn1.close(); // Освобождаем подключение
        }

        // Теперь можно получить новое подключение
        DatabaseConnection conn5 = db.getConnection();
        System.out.println("conn5 после освобождения conn1: " + (conn5 != null)); // true

        // Использование try-with-resources для автоматического закрытия
        try (DatabaseConnection conn6 = db.getConnection()) {
            if (conn6 != null) {
                conn6.addRecord("Новая запись 2");
                System.out.println("Всего записей: " + db.getRecordCount());
            }
        } // conn6 автоматически закроется здесь

        // Многопоточный пример
        System.out.println("\nМногопоточный тест:");
        for (int i = 0; i < 10; i++) {
            final int threadId = i;
            new Thread(() -> {
                try (DatabaseConnection conn = db2.getConnection()) {
                    if (conn != null) {
                        System.out.println("Поток " + threadId + " получил подключение");
                        Thread.sleep(100);
                        conn.addRecord("Из потока " + threadId);
                    } else {
                        System.out.println("Поток " + threadId + " не получил подключение");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // Даем время потокам завершиться
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nИтоговое количество записей: " + db.getRecordCount());
    }

    public static void task7_1_7(){
        Dot dot1 = DotGenerator.create2DDot(1, 6);
        Dot dot2 = DotGenerator.createDot(1, 5, 3);
        Dot dot3 = DotGenerator.create3DDot(3, 8, 0);
        System.out.println(dot1);
        System.out.println(dot2);
        System.out.println(dot3);

        //Dot dot4 = DotGenerator.createDot(1, 7, 0, 5);
    }

    public static void task7_1_8(){
        AtomicInteger attemptCount = new AtomicInteger();


        Storage<String> storage1 = Storage.createNullable(
                null, // основное значение null
                () -> {
                    System.out.println("Вычисляю альтернативное значение...");
                    // Тяжелая операция, которая выполнится ТОЛЬКО при getObj()
                    heavyComputation();
                    return "Вычисленная альтернатива";
                }
        );

        System.out.println(storage1.getObj());

        Storage<Integer> storage2 = Storage.createNullable(
                null,
                () -> {
                    attemptCount.getAndIncrement();
                    System.out.println("Попытка " + attemptCount + ": вычисление альтернативы");
                    if (attemptCount.get() < 3) {
                        throw new RuntimeException("Временная ошибка");
                    }
                    return 42;
                }
        );

        try {
            storage2.getObj(); // Бросит исключение
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            storage2.getObj(); // Снова бросит исключение
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Только с третьей попытки получим значение
        System.out.println("Значение: " + storage2.getObj());
    }

    private static void heavyComputation() {
        try {
            Thread.sleep(1000); // Имитация тяжелой операции
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void task7_1_9(){
        Name name1 = Name.builder()
                .surname("Иванов")
                .selfname("Альберт")
                .patronymic("Васильевич")
                .build();
        System.out.println(name1);
    }

    public static void task7_2_1(){
        double value = Calculator.sum(new StringSize("rjrkr"), new StringSize("rjrkdtgr"));
        System.out.println(value);
    }

    public static void task7_2_2(){
        double size = AllSizes.sumAllSizes(new StringSizing("3reur"), new StringSizing("rkjnqroer"));
        System.out.println(size);
    }

    public static void task7_2_3(){
        Cat domesticCat = new Cat("Мурзик");
        WildCat wildCat = new WildCat("Багира");

        // Вариант 1: С декоратором
        CountingMeowable countingCat = new CountingMeowable(domesticCat);
        countingCat.meow();
        countingCat.meow();
        System.out.println("Мяукнул " + countingCat.getMeowCount() + " раз");

        //int count = MeowsCount.meowsCount(wildCat);
        //System.out.println("Дикий кот мяукал " + count + " раз в тесте");
    }

    public static void task7_2_4(){
        CatDog catDog = new CatDog("Котопес");
        catDog.meow();
        catDog.bark();

        Meowable meowable = catDog;
        Barkable barkable = catDog;

        Cat cat = catDog.getCat();
        Dog dog = catDog.getDog();
    }

    public static void task7_2_5(){
        Circle circle = new Circle(DotGenerator.create2DDot(1, 0), 5);
        Circle circle1 = circle.shifted(5, 8);
        System.out.println(Arrays.toString(circle1.getPoints()));
    }

    public static void task7_2_6(){
        Dot dot1 = DotGenerator.create2DDot(1, 6);
        Dot dot2 = DotGenerator.create2DDot(-4, -7);

        Dot dot3 = DotGenerator.create2DDot(0, 4);
        Dot dot4 = DotGenerator.create2DDot(-8, -2);
        Dot dot5 = DotGenerator.create2DDot(10, -5);

        Line<Dot> line1 = new Line<>(dot3, dot4);
        Line<Dot> line2 = new Line<>(dot4, dot5);

        NewSquare square = new NewSquare(dot5, 10);

        CompositeGroup group1 = new CompositeGroup("Группа 1: Две точки");
        group1.add(dot1);
        group1.add(dot2);

        CompositeGroup group2 = new CompositeGroup("Группа 2: Две линии");
        group2.add(line1);
        group2.add(line2);

        CompositeGroup group3 = new CompositeGroup("Группа 3: Группы 1 и 2");
        group3.add(group1);
        group3.add(group2);

        CompositeGroup group4 = new CompositeGroup("Группа 4: Квадрат и группа 3");
        group4.add(square);
        group4.add(group3);

        System.out.println("\n=== Структура группы 4 ===");
        group4.printStructure();

        group4.shift(Coordinate.X, 10);

        System.out.println("Точка 1: " + dot1.getCoordinates());
        System.out.println("Линия 1 начало: " + line1.getStart().getCoordinates());
        System.out.println("Квадрат точка: " + square.getPoints()[0].getCoordinates());
    }

    public static void task7_2_7(){
        Dot start = DotGenerator.create2DDot(0, 0);
        Dot end = DotGenerator.create2DDot(3, 4);

        Line<Dot> line = new Line<>(start, end);
        CachedLine<Dot> cachedLine = new CachedLine<>(line);

        System.out.println("Первое вычисление: " + cachedLine.getSize()); // Вычисляется
        System.out.println("Второе вычисление: " + cachedLine.getSize());
    }

    public static void task7_3_1(){
        DataBase db = new DataBase(5);

        // Получаем подключение
        try (DatabaseConnection connection = db.getConnection()) {
            test(connection);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Exception");
        }
    }

    public static void test(DatabaseConnection db) {
        // Пример из картинки:
        String s = db.get(0, String.class);    // "Record_1"
        //Integer i = db.get(0, Integer.class);   // Ошибка: "Record_1" нельзя преобразовать в Integer
        Point p = db.get(10, Point.class);      // Point(5,10)

        System.out.println("String: " + s);
        //System.out.println("Integer: " + i);    // Будет исключение
        System.out.println("Point: " + p);
    }

    public static void task7_3_1_2(){
        Db db = new Db();

        // Регистрируем конвертеры
        db.registerConverter(String.class, s -> s);

        db.registerConverter(Integer.class, Integer::parseInt);

        db.registerConverter(Point.class, s -> {
            String[] parts = s.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            return new Point(x, y);
        });

        // Теперь можно вызывать как в условии
        test1(db);
    }

    public static void test1(Db db) {
        String s = db.get(0, String.class);
        Integer i = db.get(2, Integer.class); // Используем индекс 2 для числа
        Point p = db.get(1, Point.class);
        String si = db.get(2, String.class);

        System.out.println("String: " + s);      // Hello
        System.out.println("Integer: " + i);     // 42
        System.out.println("Point: " + p);       // Point{x=100, y=200}
        System.out.println("String: " + si);
    }

    public static void task7_3_3(){
        Karateka tyler = new Karateka("Тайлер");
        Karateka edward = new Karateka("Эдвард");
        CombinationManager combo = new CombinationManager("Тайлер + Эдвард");
        combo.addPunch(tyler);
        combo.addKick(edward);
        combo.addPunch(tyler);

        combo.show();
        combo.execute();

        combo.addJumpKick(edward);
        combo.addKick(tyler);
        combo.addJumpKick(tyler);

        combo.show();
        combo.execute();
    }

    public static void task7_3_4(){
        Student student = new Student("Иван", 4, 5, 3);
        System.out.println("Начальное состояние: " + student);
        System.out.println("Средний балл: " + student.getAverage());

        System.out.println("\n1. Добавляем оценку 5");
        student.addGrade(5);
        System.out.println("Текущее состояние: " + student);
        System.out.println("Средний балл: " + student.getAverage());

        System.out.println("\n2. Добавляем оценку 2");
        student.addGrade(2);
        System.out.println("Текущее состояние: " + student);
        System.out.println("Средний балл: " + student.getAverage());

        System.out.println("\n3. Меняем имя на 'Иван Петров'");
        student.setName("Иван Петров");
        System.out.println("Текущее состояние: " + student);

        if (student.undo()) {
            System.out.println("Отмена выполнена");
            System.out.println("Текущее состояние: " + student);
        }

        System.out.println("\n5. Отменяем добавление оценки 2");
        if (student.undo()) {
            System.out.println("Отмена выполнена");
            System.out.println("Текущее состояние: " + student);
            System.out.println("Средний балл: " + student.getAverage());
        }
    }

    public static void task7_3_5(){
        Student student = new Student("Иван", 4, 5, 3);
        System.out.println("Начальное состояние: " + student);

        // Получаем сохранение (Memento)
        Student.Memento savedState = student.save();

        // Вносим изменения
        student.addGrade(5);
        student.setName("Иван Петров");
        student.addGrade(2);

        System.out.println("После изменений: " + student);
        System.out.println("Средний балл: " + student.getAverage());

        // Восстанавливаем из сохранения
        student.restore(savedState);

        System.out.println("После восстановления: " + student);
        System.out.println("Средний балл: " + student.getAverage());
    }

    public static void task7_3_6_1(){
        List<String> strings = Arrays.asList(
                "apple", "123", "banana", "456", "7", "orange", "89"
        );

        // Решение через Stream API
        int sum = Stream.of(strings)
                .filter(str -> {
                    try {
                        Integer.parseInt(str);
                        return true;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .transform(Integer::parseInt)  // String -> Integer
                .reduce(0, (acc, num) -> acc + num);

        System.out.println("Сумма чисел в строках: " + sum);
    }

    public static void task7_3_6_2(){
        List<String> strings = Arrays.asList(
                "Apple", "banana", "Cherry", "date", "Eggplant"
        );

        // Решение через Stream API
        long count = Stream.of(strings)
                .filter(str -> !str.isEmpty() && Character.isUpperCase(str.charAt(0)))
                .transform(str -> 1)
                .reduce(0, (acc, num) -> acc + num);  // Просто считаем элементы

        // Альтернативное решение с использованием toList()
        List<String> uppercaseStrings = Stream.of(strings)
                .filter(str -> !str.isEmpty() && Character.isUpperCase(str.charAt(0)))
                .toList();

        System.out.println("Строк с большой буквы: " + count); // 3
        System.out.println("Список: " + uppercaseStrings);
    }

    public static void task7_3_7(){
        Declaration declaration = new Declaration("Хороший автор", "С большой буквы");
        Declaration declaration1 = new Declaration("Запрещенное имя", "Ujjjj");

        Department security = new SecurityDepartment();
        Department personnel = new PersonnelDepartment();
        Department accountant = new AccountantDepartment();

        security.setNext(personnel);
        personnel.setNext(accountant);

        security.sign(declaration);
        security.sign(declaration1);

    }

    public static void task7_3_9(){
        TrafficLight light = new TrafficLight();
        light.next();
        light.next();
        light.next();
        light.next();
        light.next();
        light.next();
    }

    public static void task7_3_10(){
        Converter textConverter = new TextConverter();
        textConverter.convert("input.txt", "output.txt");
    }

    public static void task7_3_11(){
        StudentPerson student = new StudentPerson("Петя", 452231);
        StudentPerson student1 = new StudentPerson("", 452231);
        Teacher teacher = new Teacher("Иванов", "преподаватель", 840233);
        Teacher teacher1 = new Teacher("Иванов", "", 840233);
        Teacher teacher2 = new Teacher("", "преподаватель", 840233);
        Teacher teacher3 = new Teacher("Иванов", "", 0);
        ParentPerson parent = new ParentPerson();

        SecurityGuard guard = new SecurityGuard("Михаил");

        System.out.println(guard.checkUser(student));
        System.out.println(guard.checkUser(student1));
        System.out.println(guard.checkUser(teacher));
        System.out.println(guard.checkUser(teacher1));
        System.out.println(guard.checkUser(teacher2));
        System.out.println(guard.checkUser(teacher3));
        System.out.println(guard.checkUser(parent));
    }

    public static void task7_3_12(){
        Dot dot1 = DotGenerator.create2DDot(1, 5);
        Dot dot2 = DotGenerator.create2DDot(7, 0);
        Dot dot3 = DotGenerator.create2DDot(-1, 15);
        Dot dot4 = DotGenerator.create2DDot(9, -12);

        BrokenLine brokenLine = new BrokenLine(dot1, dot2, dot3, dot4);
        ClosedPolyline polyline = new ClosedPolyline(dot1, dot2, dot3, dot4);

        PolylineIterator brokenIterator = brokenLine.iterator();

        while(brokenIterator.hasNext()){
            Dot dot = brokenIterator.next();
            System.out.println(dot);
        }
        System.out.println("Последняя точка (без перемещения): " + brokenIterator.current().getCoordinates());

        PolylineIterator closedIterator = polyline.iterator();

        for (int i = 0; i < 7; i++) {
            Dot dot = closedIterator.next();
            System.out.println("Точка " + i + ": " + dot.getCoordinates());
        }

        System.out.println("\n=== Тест с началом с определенной точки ===");
        PolylineIterator iteratorFromMiddle = brokenLine.iterator(1); // Начинаем со второй точки
        System.out.println("Начинаем с точки: " + iteratorFromMiddle.current().getCoordinates());

        while (iteratorFromMiddle.hasNext()) {
            Dot dot = iteratorFromMiddle.next();
            System.out.println("Следующая: " + dot.getCoordinates());
        }
    }

    public static void task8_1_1(){
        Line<Dot> line = new Line<>(DotGenerator.create2DDot(1, 5), DotGenerator.create2DDot(-5, 0));
        List<Field> fields = CollectFields.fieldCollection(line.getClass());
        System.out.println(fields);
        String str = new String();
        List<Field> fields2 = CollectFields.fieldCollection(str.getClass());
        System.out.println(fields2);
        KickCommand cmd = new KickCommand(new Karateka("Me"));
        List<Field> fields3 = CollectFields.fieldCollection(cmd.getClass());
        System.out.println(fields3);
    }

    public static void task8_1_2() throws NoSuchFieldException, IllegalAccessException {
        Line<Dot> line1 = new Line<>(DotGenerator.create2DDot(1, 5), DotGenerator.create2DDot(1, 0));
        Line<Dot> line2 = new Line<>(DotGenerator.create2DDot(9, 2), DotGenerator.create2DDot(4, 8));
        LinesConnector.<Dot>lineConnector(line1, line2);

        Dot end1 = line1.getEnd();
        Dot start2 = line2.getStart();
        System.out.println(end1.equals(start2));

    }

    public static void task8_1_3(){
        A a = new A();
        System.out.println(a);
        B b = new B();
        System.out.println(b);
    }

    public static void task8_1_4(){
        Human human1 = new Human("Васька", 300);
        String human2Name = "skdllllllllllllorjfwpojowhwprhwivnivwp[wntiqbgtebgeoarvaiugrevp895gq938gb8rvbaiuuirbiegllvnnnnnnnnnnnnnksldmclsdkmcsldkmcslkdmcsklmcsldmcsldkmcsleiwioebvobvuobowebweinpvnpdwrwelmw;eflw";
        Human human2 = new Human(human2Name, 14);
        System.out.println(human2Name.length());
        Validator.validate(human2, HumanTest.class);
    }

    public static void task8_1_5() throws IOException {
        try{
            List<Object> objects = Arrays.asList(
                    new Human("Иванушка", 27),
                    new Human("Прикольная_девушка", 20),
                    new Cat("Мурзик")
            );
            ObjectWriter writer = new ObjectWriter("objects.txt");
            writer.write(objects);
            System.out.println("Записано в файл");

            ObjectReader<Human> reader = new ObjectReader<>("objects.txt", Human.class);
            List<Human> humans = reader.read();

            System.out.println("\nПрочитанные объекты Human:");
            for (Human human : humans) {
                System.out.println(human);
            }
        }

        catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }



}
