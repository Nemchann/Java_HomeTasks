public class Sparrow extends Bird implements Singable{

    public Sparrow(){

    }
    @Override
    public String sing(){
        return "Воробей поет: Чирик!";
    }

    @Override
    public String songs() {
        return sing();
    }
}
