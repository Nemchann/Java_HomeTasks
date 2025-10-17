public class WildCat extends Cat implements Meowable{
    public WildCat(String name){
        super(name);
    }

    @Override
    public void meow() {
        System.out.println(name + ": РРР!-Мырр!-Шшшш!");
    }
}
