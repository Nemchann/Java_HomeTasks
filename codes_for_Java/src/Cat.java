public class Cat {
    String name;

    public Cat(String name){
        this.name = name;
    }

    public void tellName() {
        System.out.println("Кот: " + name);
    }

    public void tellMeow() {
        System.out.println(name + ": Мяу!");
    }

    public void tellMeow(int n) {
        String meows = name + ": ";
        for (int i = 0; i < n; i++){
            meows += "-мяу";
        }
        meows += "!";
        System.out.println(meows);
    }

}
