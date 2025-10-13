import java.util.concurrent.ThreadLocalRandom;

public class Cuckoo extends Bird{

    public Cuckoo(){

    }
    @Override
    public void sing(){
        int count = ThreadLocalRandom.current().nextInt(1, 11);
        String result = "Кукушка поет " + count + " раз.\n";
        for (int i = 0; i < count; i++){
            result += "Ку-ку!\n";
        }
        System.out.println(result);
    }
}
