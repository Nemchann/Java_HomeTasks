public class Name {
    String surname;
    String selfname;
    String patronymic;


    public String toString() {
        String result = "Человек с именем";

        if (surname != null) result += " " + surname;

        if (selfname != null) result += " " + selfname;

        if (patronymic != null) result += " " + patronymic;

        return result;
    }
}
