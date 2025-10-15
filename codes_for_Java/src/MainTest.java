import java.util.Arrays;

public class MainTest {
    public static void task1_4_1(){
        Dot dot1 = new Dot(3, 5);
        Dot dot2 = new Dot(25, 6);
        Dot dot3 = new Dot(7, 8);
        System.out.println("1.4.1");
        System.out.println(dot1);
        System.out.println(dot2);
        System.out.println(dot3);
        System.out.println("\n");
    }

    public static void task1_4_2(){
        Dot dot4 = new Dot(1, 3);
        Dot dot5 = new Dot(23, 8);
        Line line1 = new Line(dot4, dot5);
        Line line2 = new Line(5, 10, 25, 10);
        Line line3 = new Line(line1.getStart(), line2.getEnd());
        System.out.println("1.4.2");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println("\n");
    }

    public static void task1_4_3(){
        Dot dot6 = new Dot(3, 5);
        Dot dot7 = new Dot(25, 6);
        Dot dot8 = new Dot(7, 8);
        BrokenLine spline1 = new BrokenLine(dot6, dot7, dot8);
        System.out.println("1.4.3");
        System.out.println(spline1);
        System.out.println("\n");
    }

    public static void task1_4_4(){
        House house1 = new House(2);
        House house2 = new House(35);
        House house3 = new House(91);
        System.out.println("1.4.4");
        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);
        System.out.println("\n");
    }

    public static void task1_4_5(){
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
    }

    public static void task1_4_6(){
        Human human1 = new Human("Лев");
        Name name5 = new Name("Сергей", "Пушкин");
        Human human2 = new Human(human1, name5);
        Human human3 = new Human(human2, "Александр");
        System.out.println("1.4.6");
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println("\n");
    }

    public static void task1_4_7(){
        Student student1 = new Student("Вася", 3, 4, 5);
        Student student2 = new Student("Максим");
        System.out.println("1.4.7");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println("\n");
    }

    public static void task1_4_8(){
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
    }

    public static void task1_5_1(){
        Gun gun1 = new Gun(3,5);
        System.out.println("1.5.1");
        gun1.fire();
        gun1.fire();
        gun1.fire();
        gun1.fire();
        gun1.fire();
        System.out.println("\n");
    }

    public static void task1_5_2(){
        Cat cat1 = new Cat("Барсик");
        System.out.println("1.5.2");
        cat1.tellMeow();
        cat1.tellMeow(3);
        System.out.println("\n");
    }

    public static void task1_5_3(){
        Line line153 = new Line(1, 1, 10, 15);
        System.out.println("1.5.3");
        System.out.println(line153.getSpace());
        System.out.println("\n");
    }

    public static void task1_5_4(){
        System.out.println("1.5.4");
        Human human154_1 = new Human(new Name("Колыван", "Попов", "Прохорович"));
        Human human154_2 = new Human(human154_1, "Потап");
        Human human154_3 = new Human(human154_2, "Шут");
        System.out.println(human154_2.getSurname());
        System.out.println(human154_3.getSurname());
        System.out.println(human154_2);
        System.out.println(human154_3);
        System.out.println("\n");
    }

    public static void task1_5_5(){
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
    }

    public static void task1_5_6(){
        Student student156_1 = new Student("Вася", new int[]{3, 4, 5, 4});
        Student student156_2 = new Student("Петя", new int[]{5, 5, 5, 5});
        System.out.println("1.5.6");
        student156_1.getInfo();
        student156_2.getInfo();
        System.out.println("\n");
    }

    public static void task1_5_7(){
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
    }

    public static void task1_5_8(){
        Square square1 = new Square(5, 3, 23);
        BrokenLine squareLine = square1.polyline();
        System.out.println("1.5.8");
        System.out.println(squareLine);
        System.out.println(squareLine.splineLength());
        squareLine.points[3] = new Dot(15, 25);
        System.out.println(squareLine.splineLength());
        System.out.println("\n");
    }

    public static void task1_6_1(){
        System.out.println("1.6.1");
        House house161_1 = new House(5);
//        House house161_2 = new House(-5);
        System.out.println(house161_1);
//        System.out.println(house161_2);
        System.out.println("\n");
    }

    public static void task1_6_2(){
        System.out.println("1.6.2");
        Name name6 = new Name("", "Смирнов");
//        Name name7 = new Name("");
        System.out.println(name6);
//        System.out.println(name7);
        System.out.println("\n");
    }

    public static void task1_6_3(){
        System.out.println("1.6.3");
        Square square163_1 = new Square(new Dot(3, 5), 3);
//        square163_1.setSquare(0, 2, 4);
//        square163_1.getSquare();
        Square square163_2 = new Square(new Dot(9, 0), 5);
        square163_2.setSquare(1, 2, 4);
        square163_2.getSquare();
        System.out.println("\n");
    }

    public static void task1_6_4(){
        System.out.println("1.6.4");
        Fraction fraction164_1 = new Fraction(3, 6);
        System.out.println(fraction164_1);
//        fraction164_1.numerator = 4; - нельзя изменить
//        Fraction fraction164_2 = new Fraction(5, -6); - нельзя сделать отрицательный знаменатель
        System.out.println("\n");
    }

    public static void task1_6_5(){
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
        System.out.println("\n");
    }

    public static void task1_6_6(){
        System.out.println("1.6.6");
        Dot dot166_1 = new Dot(0, 0);
        Dot dot166_2 = new Dot(5, 5);
        Dot dot166_3 = new Dot(-10, -10);

        Line line166_1 = new Line(dot166_1, dot166_2);
        Line line166_2 = new Line(dot166_2, dot166_3);

        dot166_2.x = 20;
        dot166_2.y = -20;
        System.out.println("Line1: " + line166_1);
        System.out.println("Line2: " + line166_2);

        Dot dotGetter1 = line166_1.getStart();
        dotGetter1.x = 100;
        System.out.println("Line1 после применения геттера: " + line166_1);
        System.out.println("\n");
    }

    public static void task1_6_7(){
        System.out.println("1.6.7");
        Human human167_1 = new Human(new Name("Александр", "Сидоров"));
        Human human167_2 = new Human(human167_1, "Ярослав");
        Human human167_3 = new Human("Антон");
//        human167_2.father = human167_3;  - выведет исключение
        System.out.println(human167_2);
        System.out.println("\n");
    }

    public static void task1_6_8(){
        System.out.println("1.6.8");
        Student student3 = new Student("Саша", 4, 5, 2);
//        Student student4 = new Student("Коля", 1, 0, 10);
        System.out.println(Arrays.toString(student3.getGrades()));
//        System.out.println(student4);
        System.out.println("\n");
    }

    public static void task1_6_9(){
        System.out.println("1.6.9");
        City Aa = new City("A");
        City Cc = new City("C");
        City Dd = new City("D");
        City Bb = new City("B");

        Aa.addPath(Bb, 5);
        Aa.addPath(Dd, 6);
        System.out.println("Для А обновили пути:\n" + Aa);

        Aa.addPath(Bb, 3);
        System.out.println("Снова для А обновили путь:\n " + Aa);

        Bb.addPath(Aa, 3);
        Dd.addPath(Aa, 6);
        System.out.println("Добавили обратные пути:\n" + Bb);

        Aa.removePath(Dd);
        System.out.println("Для А удалили один путь:\n " + Aa);

        int cost = Aa.getPathCost(Bb);
        System.out.println("Стоимость пути A-B: " + cost);
        System.out.println("\n");
    }

    public static void task1_6_10(){
        Department itDepartment = new Department("IT");

        Employee boss = itDepartment.addBoss("Петров");
        System.out.println(boss);

        itDepartment.addEmployee(new Employee("Иванов"));
        itDepartment.addEmployee(new Employee("Сидоров"));

        System.out.println("Все сотрудники отдела:");
        for (Employee emp : itDepartment.getEmployees()) {
            System.out.println("- " + emp.getName());
        }

        Employee ivanov = itDepartment.getEmployees().get(1); // Иванов
        itDepartment.setBoss(ivanov);
        System.out.println(ivanov);

        Department hrDepartment = new Department("HR");
        Employee hrEmployee = new Employee("Козлов");
        hrDepartment.addEmployee(hrEmployee);

        itDepartment.setBoss(hrEmployee);
        System.out.println(hrEmployee);
        System.out.println("\n");
    }

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
//        BankAccount bankAccount1 = new BankAccount("", "01.01.2000", "1234 123456");
    }

    public static void task2_1_1(){
//        class NewFraction extends Fraction{
//            public Fraction(int numerator, int denominator){
//                if (denominator <= 0){
//                    throw new IllegalArgumentException("denominator must be positive");
//                }
//                int divisor = greatestCommonDivisor(Math.abs(numerator), Math.abs(denominator));
//                this.numerator = numerator / divisor;
//                this.denominator = denominator / divisor;
//            }
//        }
    }

    public static void task2_1_2(){
        Dot dot1 = new Dot(3, 4);
        Dot dot2 = new Dot(3, -4);
        Dot dot3 = new Dot(6, -4);
        Dot dot4 = new Dot(6, 4);
        ClosedPolyline spline1 = new ClosedPolyline(dot1, dot2, dot3, dot4);
        System.out.println(spline1.splineLength());
    }

    public static void task2_1_3(){
        // Создаем инновационные города
        InnovativeCity moscow = new InnovativeCity("Москва");
        InnovativeCity spb = new InnovativeCity("Санкт-Петербург");
        InnovativeCity kazan = new InnovativeCity("Казань");

        System.out.println("До добавления путей:");
        System.out.println(moscow);
        System.out.println(spb);

        // Добавляем путь - автоматически создается обратный
        moscow.addPath(spb, 700);

        System.out.println("\nПосле добавления пути Москва-СПб:");
        System.out.println("Москва:");
        System.out.println(moscow);
        System.out.println("СПб:");
        System.out.println(spb);

        // Добавляем еще один путь
        moscow.addPath(kazan, 800);

        System.out.println("\nПосле добавления пути Москва-Казань:");
        System.out.println("Москва:");
        System.out.println(moscow);
        System.out.println("Казань:");
        System.out.println(kazan);

        // Обновляем стоимость - обновляются оба пути
        moscow.addPath(spb, 650);

        System.out.println("\nПосле обновления стоимости Москва-СПб:");
        System.out.println("Москва:");
        System.out.println(moscow);
        System.out.println("СПб:");
        System.out.println(spb);

        // Удаляем путь - удаляются оба направления
        moscow.removeBidirectionalPath(kazan);

        System.out.println("\nПосле удаления пути Москва-Казань:");
        System.out.println("Москва:");
        System.out.println(moscow);
        System.out.println("Казань:");
        System.out.println(kazan);
    }

    public static void task2_1_4(){
        MachineGun gun1 = new MachineGun();
        MachineGun gun2 = new MachineGun(20);
        MachineGun gun3 = new MachineGun(40, 10);
        System.out.println("Gun1:\n");
        gun1.patrons = 30;
        gun1.fire();
        System.out.println("Gun2:\n");
        gun2.patrons = 10;
        gun2.fire(3);
        System.out.println("Gun3:\n");
        gun3.patrons = 20;
        gun3.fire(3);
    }

    public static void task2_1_5(){
        ThreeCoordinatesDot dot1 = new ThreeCoordinatesDot(5, 3);
        ThreeCoordinatesDot dot2 = new ThreeCoordinatesDot(4, -8, 10);
        System.out.println(dot1);
        System.out.println(dot2);
    }

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

    public static void task2_2_4(){
        Dot dotCircle = new Dot(0, 5);
        Dot dotSquare = new Dot(10, 5);
        Dot dotTriangle1 = new Dot(4, 8);
        Dot dotTriangle2 = new Dot(-3, 0);
        Dot dotTriangle3 = new Dot(6, -9);
        Dot dotRectangle = new Dot(1, 4);

        Circle circle = new Circle(dotCircle, 4);
        NewSquare square = new NewSquare(dotSquare, 5);
        Triangle triangle = new Triangle(dotTriangle1, dotTriangle2, dotTriangle3);
        Rectangle rectangle = new Rectangle(dotRectangle, 4, 7);

        System.out.println(circle.getArea());
        System.out.println(square.getArea());
        System.out.println(triangle.getArea());
        System.out.println(rectangle.getArea());

    }

    public static void task2_2_5(){
        // Точка в координате 3, красного цвета
        AbstractDot point1 = DotWithCharacteristics.wrap(new Dot(3, 0))
                .withColor("красный");
        System.out.println(point1.getDescription());
        // Точка в координате {3; 0}, красного цвета

        AbstractDot point2 = DotWithCharacteristics.wrap(new Dot(-3, 10))
                .withColor("синий")
                .withSize(20);
        System.out.println(point2.getDescription());
    }
}
