import java.util.concurrent.ThreadLocalRandom;

public class Cuckoo extends Bird implements Singable{

    public Cuckoo(){

    }
    @Override
    public String sing(){
        int count = ThreadLocalRandom.current().nextInt(1, 11);
        String result = "Кукушка поет " + count + " раз.\n";
        for (int i = 0; i < count; i++){
            result += "Ку-ку! ";
        }
        return result;
    }

    @Override
    public String songs() {
        return sing();
    }
}
