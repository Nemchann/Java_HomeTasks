
public class Main {
    public static void main(String[] args) {
        Name name1 = new Name();
        name1.selfname = "Клеопатра";
        Human human1 = new Human();
        human1.fullName = name1;
        human1.height = 152;
        System.out.println(human1);

        Name name2 = new Name();
        name2.surname = "Пушкин";
        name2.selfname = "Александр";
        name2.patronymic = "Сергеевич";
        Human human2 = new Human();
        human2.fullName = name2;
        human2.height = 167;
        System.out.println(human2);

        Name name3 = new Name();
        name3.surname = "Маяковский";
        name3.selfname = "Владимир";
        Human human3 = new Human();
        human3.fullName = name3;
        human3.height = 189;
        System.out.println(human3);
    }
}