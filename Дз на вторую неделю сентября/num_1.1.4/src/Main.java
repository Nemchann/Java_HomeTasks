class Time {
    int allSeconds;
//    В теле класса действия описывать нельзя, только в методе
    public String toString(){
        int seconds = this.allSeconds;
        int minutes = 0;
        int hours = 0;

        while(seconds >= 60){
            seconds -= 60;
            minutes++;
        }
        while(minutes >= 60){
            minutes -= 60;
            hours++;
        }
        while(hours >= 24) {
            hours -= 24;
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }


}
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