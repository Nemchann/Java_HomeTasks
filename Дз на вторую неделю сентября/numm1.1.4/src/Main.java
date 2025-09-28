public class Main {
    public static void main(String[] args) {
//        10 секунд
        Time time1 = new Time();
        time1.allSeconds = 10;
        System.out.println(time1);
        //    Ответ: 00:00:10

//        10000 секунд
        Time time2 = new Time();
        time2.allSeconds = 10000;
        System.out.println(time2);
        //        Ответ: 2:46:40

//        100000 секунд
        Time time3 = new Time();
        time3.allSeconds = 100000;
        System.out.println(time3);
        //        Ответ: 3:46:40
    }
}