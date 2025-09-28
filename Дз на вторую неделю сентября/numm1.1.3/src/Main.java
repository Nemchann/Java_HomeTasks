public class Main {
    public static void main(String[] args) {
        Name name1 = new Name();
        name1.selfname = "Клеопатра";
        System.out.println(name1);

        Name name2 = new Name();
        name2.surname = "Пушкин";
        name2.selfname = "Александр";
        name2.patronymic = "Сергеевич";
        System.out.println(name2);

        Name name3 = new Name();
        name3.surname = "Маяковский";
        name3.selfname = "Владимир";
        System.out.println(name3);

    }
}