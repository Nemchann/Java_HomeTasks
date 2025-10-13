import java.util.concurrent.ThreadLocalRandom;

public class Parrot extends Bird{
    protected String text;

    public Parrot(String text){
        this.text = text;
    }

    @Override
    public void sing() {
        int count = ThreadLocalRandom.current().nextInt(1, text.length());
        String result = "Попугай говорит: ";
        for (int i = 0; i < count; i++){
            result += text.charAt(i);
        }
        System.out.println(result);
    }
}
