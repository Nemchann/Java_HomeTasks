package com.nemchann.training;

import com.nemchann.training.auditing.BankService;
import com.nemchann.training.auditing.BankServiceInterface;
import com.nemchann.training.caching.MathService;
import com.nemchann.training.caching.MathServiceInterface;
import com.nemchann.training.checking_parameteres.AuthService;
import com.nemchann.training.checking_parameteres.AuthServiceInterface;
import com.nemchann.training.class_analyzer.ClassAnalyzer;
import com.nemchann.training.flexible_configuration.OperationProcessor;
import com.nemchann.training.lazy_logging.CalculatorServiceInterface;
import com.nemchann.training.logging_processor.LogExecutionBeanPostProcessor;
import com.nemchann.training.logging_processor.UserService;
import com.nemchann.training.logging_processor.UserServiceInterface;
import com.nemchann.training.notifying.NotificationService;
import com.nemchann.training.private_method_invokation.SecretCalculator;
import com.nemchann.training.private_method_invokation.SecretCalculatorInvoke;
import com.nemchann.training.smart_caching.SmartMathService;
import com.nemchann.training.smart_caching.SmartMathServiceInterface;
import com.nemchann.training.spring_configuration.GreetingController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.nemchann")
public class TrainingTest {
    public static void ex_1() {
        ClassAnalyzer.analyzeClass("com.nemchann.training.class_analyzer.Human");
    }
    public static void ex_2(){
        SecretCalculatorInvoke.calculateInvoke(3, 5, new SecretCalculator());
    }

    //Создает контекст
    public static ApplicationContext applicationContext(){
        return new AnnotationConfigApplicationContext("com.nemchann");
    }

    public static void ex_3(){
        ApplicationContext context = applicationContext();

        GreetingController controller = context.getBean("greetingController", GreetingController.class);
        controller.printGreeting("Petya");
    }

    public static void ex_4(){
        ApplicationContext context = applicationContext();
        NotificationService service = context.getBean(NotificationService.class);

        service.notifyAll("Интересное сообщение");
    }

    public static void ex_5(){
        ApplicationContext context = applicationContext();
        OperationProcessor processor = context.getBean(OperationProcessor.class);
        processor.process(2, 6);
    }

    public static void ex_6() {
        ApplicationContext context = applicationContext();

        UserServiceInterface service = context.getBean(UserServiceInterface.class);

        System.out.println("Тестирование методов");
        service.fastMethod();
        service.slowMethod();
        service.normalMethod();
    }

    public static void ex_7(){
        ApplicationContext context = applicationContext();
        BankServiceInterface service = context.getBean(BankServiceInterface.class);

        service.deposit(200);
        service.withdraw(50);
        service.getBalance();
    }

    // Как раз всё создает, вызывать данный метод в main
    public static void ex_8(){
        ApplicationContext context = applicationContext();
        AuthServiceInterface service = context.getBean(AuthServiceInterface.class);

        service.calculateSum(100, 200);
        service.login("admin", "secret123");
        service.freeMethod("FREE METHOD");
        service.processFlag(false);
    }

    public static void ex_9(){
        ApplicationContext context = applicationContext();
        MathServiceInterface service = context.getBean(MathServiceInterface.class);

        service.factorial(6);
        service.factorial(6);
        System.out.println();
        service.fibonacci(3);
        service.fibonacci(3);
    }
    public static void ex_10(){
        ApplicationContext context = applicationContext();
        CalculatorServiceInterface service = context.getBean(CalculatorServiceInterface.class);
        service.normalMode();
        service.add(1, 4);
        service.subtract(3, 1);
        service.silentMode();
        service.add(2, 7);
    }

    public static void ex_11(){
        ApplicationContext context = applicationContext();
        SmartMathServiceInterface service = context.getBean(SmartMathServiceInterface.class);
        service.factorial(3);
        service.factorial(4);
        service.factorial(4);
    }
}
