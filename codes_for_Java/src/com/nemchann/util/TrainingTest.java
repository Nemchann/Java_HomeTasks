package com.nemchann.util;

import com.nemchann.training.app.AppConfig;
import com.nemchann.training.logging.*;
import com.nemchann.training.building.User;
import com.nemchann.training.adapter.*;
import com.nemchann.training.decorator.*;
import com.nemchann.training.observer.*;
import com.nemchann.training.strategy.*;
import com.nemchann.training.composite.*;
import com.nemchann.training.facade.*;
import com.nemchann.training.visitor.*;
import com.nemchann.training.state.*;
import com.nemchann.training.command.*;
import com.nemchann.training.proxy.*;
import com.nemchann.training.chain_of_responsibility.*;
import com.nemchann.training.iterator.*;
import com.nemchann.training.bridge.*;

import com.nemchann.training.coffee_shop.CoffeeShopManager;
import com.nemchann.training.coffee_shop.factory.*;
import com.nemchann.training.coffee_shop.strategy.*;
import com.nemchann.training.coffee_shop.observer.*;
import com.nemchann.training.coffee_shop.decorator.*;

import com.nemchann.training.smart_house.SmartHomeController;
import com.nemchann.training.smart_house.command.*;
import com.nemchann.training.smart_house.facade.*;
import com.nemchann.training.smart_house.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class TrainingTest {
    public static void ex1_1(){
        AppConfig appConfig = AppConfig.getInstance();
        AppConfig appConfig1 = AppConfig.getInstance();

        System.out.println(appConfig1 == appConfig);
        System.out.println(appConfig.getAppName());
        System.out.println(appConfig1.getAppName());
    }

    public static void ex1_2(){
        // Клиентский код работает ТОЛЬКО с абстракциями
        LoggerFactory factory = new FileLoggerFactory();
        Logger logger = factory.createLogger(); // Создаем логгер через фабрику

        logger.log("Лог запустился");

        // Демонстрация смены фабрики
        factory = new ConsoleLoggerFactory();
        logger = factory.createLogger();
        logger.log("Теперь логируем в консоль");
    }

    public static void ex1_3(){
        User user = new User.UserBuilder("Василий", "Евгеньев")
                .setAddress("Саратов")
                .setAge(26)
                .setPhone("=79371223344")
                .build();
        System.out.println(user);
    }

    public static void ex2_1(){
        OldPrinter op = new OldPrinter();
        ModernPrinter mp = new PrinterAdapter(op);
        mp.print("parrot");
    }

    public static void ex2_2(){
        String message = "Messages";
        Notifier notifier = new EmailNotifier();
        notifier = new SmsNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);
        notifier = new LoggingNotifierDecorator(notifier);

        notifier.send(message);
        System.out.println("/n");

        String message1 = "Очень срочно!";
        Notifier notifier1 = new EmailNotifier();
        notifier1 = new SlackNotifierDecorator(new LoggingNotifierDecorator(new SmsNotifierDecorator(notifier1)));

        notifier1.send(message1);

    }

    public static void ex3_1(){
        WeatherStation weatherStation = new WeatherStation();
        Observer phone = new PhoneDisplay();
        Observer tv = new TVDisplay();

        weatherStation.registerObserver(phone);
        weatherStation.registerObserver(tv);

        weatherStation.setMeasurements(25.5f, 65f);
    }

    public static void ex3_2(){
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardStrategy("1234-5678-9012-3456"));
        cart.checkout(100.0);

        cart.setPaymentStrategy(new PayPalStrategy("user@example.com"));
        cart.checkout(50.0);
    }

    public static void coffeeTask(){
        CoffeeShopManager shop = CoffeeShopManager.getInstance();

        Coffee espresso = CoffeeFactory.createCoffee("espresso");

        espresso = new MilkDecorator(espresso); // + 20 рублей
        espresso = new SugarDecorator(espresso); // + 10 рублей

        System.out.println("Заказ: " + espresso.getDescription());
        System.out.println("Цена: " + espresso.getCost()); // 50 + 20 + 10 = 80

        shop.setPaymentStrategy(new CardPayment("2202 2023 5896 3011"));

        Customer customer = new Customer("Peter");
        shop.placeOrder(espresso, customer);

    }

    public static void ex4_1(){
        MenuComponent egg = new MenuItem("Яйцо", 50);
        MenuComponent milk = new MenuItem("Молоко", 30);
        MenuComponent cheese = new MenuItem("Сыр", 50);

        MenuComposite omelette = new MenuComposite("Омлет");
        omelette.addItem(egg);
        omelette.addItem(milk);
        omelette.addItem(cheese);

        omelette.print();

        MenuComponent coffee = new MenuItem("Латте", 150);

        MenuComposite breakfast = new MenuComposite("Завтрак");
        breakfast.addItem(coffee);
        breakfast.addItem(omelette);

        breakfast.print();
    }

    public static void ex4_2(){
        CoffeeMachineFacade machine = new CoffeeMachineFacade();
        machine.makeCappuccino();
        machine.makeEspresso();
        machine.cleanMachine();
    }

    public static void ex5_1(){
        Visitor visitor = new HTMLVisitor();
        List<TextElement> textElements = new ArrayList<>();

        TextElement image = new Image("ссылка", "alt");
        TextElement paragraph = new Paragraph("much text");
        List<List<String>> strings = new ArrayList<>();
        List<String> string1 = new ArrayList<>();
        string1.add("svsvs");
        string1.add("svsvs");
        string1.add("svsvs");
        List<String> string2 = new ArrayList<>();
        string2.add("fdvdfv");
        string2.add("fdvdfv");
        strings.add(string1);
        strings.add(string2);
        TextElement table = new Table(strings);

        textElements.add(image);
        textElements.add(paragraph);
        textElements.add(table);

        for (TextElement textElement : textElements){
            textElement.accept(visitor);
        }

    }

    public static void ex5_2(){
        Music music = new Music("Lay on your love", 3.5);
        Music music1 = new Music("Believer", 3.0);
        Music music2 = new Music("Last Christmas", 4);
        Music music3 = new Music("Jingle Bells", 2.5);

        List<Music> melodies = new ArrayList<>();
        melodies.add(music);
        melodies.add(music1);
        melodies.add(music2);
        melodies.add(music3);

        Player player = new Player(melodies);

        player.play();      // Начинаем воспроизведение (ReadyState → PlayingState)
        player.next();      // Следующий трек (PlayingState)
        player.pause();     // Пауза (PlayingState → PausedState)
        player.play();      // Продолжить (PausedState → PlayingState)
        player.prev();      // Предыдущий трек (PlayingState)
        player.pause();     // Снова пауза (PlayingState → PausedState)
        player.next();      // Следующий с паузы (PausedState)
        player.play();

        System.out.println();
        Player player2 = new Player(melodies);
        player2.pause();    // Пытаемся поставить на паузу из ReadyState
        player2.play();     // Начинаем воспроизведение
        player2.play();     // Пытаемся play снова из PlayingState
    }

    public static void ex5_3(){
        Light livingRoomLight = new Light("Гостиная");
        Light kitchenLight = new Light("Кухня");
        Stereo stereo = new Stereo();

        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);
        Command stereoOn = new StereoOnWithCDCommand(stereo);
        Command stereoOff = new StereoOffCommand(stereo);

        List<Command> partyCommands = new ArrayList<>();
        partyCommands.add(livingRoomLightOn);
        partyCommands.add(kitchenLightOn);
        partyCommands.add(stereoOn);
        Command partyMacro = new MacroCommand(partyCommands);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, stereoOn, stereoOff);
        remote.setCommand(3, partyMacro, new NoCommand());

        remote.pressOnButton(0);  // Включить свет в гостиной
        remote.pressOnButton(2);  // Включить стерео
        remote.pressOffButton(0);

        System.out.println("\n--- Отмена последней команды ---");
        remote.pressUndoButton(); // Вернём свет в гостиной

        System.out.println("\n--- Запуск макроса 'Вечеринка' ---");
        remote.pressOnButton(3);  // Запускаем макрос

        System.out.println("\n--- Отмена макроса ---");
        remote.pressUndoButton(); // Отменяем макрос

        System.out.println("\n--- Состояние пульта ---");
        System.out.println(remote);
    }

    public static void ex5_4(){
        VideoDownloadService service = new VideoDownloadService();
        CachingProxy proxy = new CachingProxy(service);
        VideoManager manager = new VideoManager(proxy);

        manager.getVideo(0);
        manager.getVideo(1);
        manager.getVideo(0);
    }

    public static void smartHouseTask(){
        SmartHomeController controller = SmartHomeController.getInstance();
        SmartHouseRemoteControl remoteControl = new SmartHouseRemoteControl(controller);
        remoteControl.setMode(new ComfortMode());

        remoteControl.setCommand(0, new HumidityReduceSmartCommand(controller));
        remoteControl.setCommand(1, new LightsOnSmartCommand(controller));
        remoteControl.setCommand(2, new LightsOffSmartCommand(controller));

        remoteControl.pressOnButton(0);
        remoteControl.pressOnButton(1);
        remoteControl.pressOnButton(2);
    }

    public static void ex6_1(){
        LoanRequest request = new LoanRequest(500000, 5, "образование");
        LoanRequest request1 = new LoanRequest(4000, 4, "Надо");
        LoanRequest request2 = new LoanRequest(-18290, 4, "лечение");

        Handler validator = new Validator();
        Handler checker = new CreditChecker();
        Handler manager = new LoanManager();
        Handler notifier = new CreditNotifier();

        validator.setNext(checker);
        checker.setNext(manager);
        manager.setNext(notifier);

        System.out.println("Кредит 1");
        validator.handle(request);

        System.out.println("Кредит 2");
        validator.handle(request1);

        System.out.println("Кредит 3");
        validator.handle(request2);
    }

    public static void ex6_2(){
        Book book1 = new Book("Война и мир", "Л.Н. Толстой", 1960);
        Book book2 = new Book("Преступление и наказание", "Ф.М.Достоевский", 1975);
        Book book3 = new Book("Евгений Онегин", "А.С.Пушкин", 1930);

        BookShelf shelf = new BookShelf(3);
        shelf.add(book1);
        shelf.add(book2);
        shelf.add(book3);

        Iterator shelfIterator = new ShelfIterator(shelf);

        while (shelfIterator.hasNext()){
            System.out.println(shelfIterator.next());
        }
        System.out.println();
        Iterator reversedIterator = new ReversedShelfIterator(shelf);

        while (reversedIterator.hasNext()){
            System.out.println(reversedIterator.next());
        }
    }

    public static void ex6_3(){
        Renderer vector = new VectorRenderer();
        Renderer raster = new RasterRenderer();
        Shape circle = new Circle(vector);
        Shape square = new Square(raster);

        circle.draw();
        square.draw();
    }
}
