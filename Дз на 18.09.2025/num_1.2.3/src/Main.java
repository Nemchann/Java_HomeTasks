public class Main {
    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human();
        Human human3 = new Human();

        Name name1 = new Name();
        name1.surname = "Чудов";
        name1.selfname = "Иван";
        human1.fullName = name1;
        System.out.println(human1);

        Name name2 = new Name();
        name2.surname = "Чудов";
        name2.selfname = "Петр";
        human2.fullName = name2;
        human2.father = human1;

        System.out.println(human2);

        Name name3 = new Name();
        name3.selfname = "Борис";
        human3.fullName = name3;
        human3.father = human2;
        System.out.println(human3);
    }
}