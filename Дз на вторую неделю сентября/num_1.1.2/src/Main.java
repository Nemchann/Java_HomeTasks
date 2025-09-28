class Human {
    String name;
    int height;

    public String toString(){
        "Человек с именем " + name + " и ростом " + height;
    }
}

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human();
        human1.name = "Клеопатра";
        human1.height = 152;
        System.out.println(human1);

        Human human2 = new Human();
        human2.name = "Пушкин";
        human2.height = 167;
        System.out.println(human2);

        Human human3 = new Human();
        human3.name = "Александр";
        human3.height = 189;
        System.out.println(human3);
    }
}