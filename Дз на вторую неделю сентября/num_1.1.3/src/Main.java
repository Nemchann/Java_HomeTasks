class Name {
    String surname;
    String selfname;
    String patronymic;


    public String toString() {
        StringBuilder result = new StringBuilder();

        if (surname != null && !surname.isEmpty()) {
            result.append(surname);
        }

        if (selfname != null && !selfname.isEmpty()) {
            if (!result.isEmpty()) result.append(" ");
            result.append(selfname);
        }

        if (patronymic != null && !patronymic.isEmpty()) {
            if (!result.isEmpty()) result.append(" ");
            result.append(patronymic);
        }

        return result.toString();
    }
}

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