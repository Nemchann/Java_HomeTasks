class Name {
    String surname;
    String selfname;
    String patronymic;

    public Name(String selfname){
        this.selfname = selfname;
    }

    public Name(String selfname, String surname){
        this.selfname = selfname;
        this.surname = surname;
    }

    public Name(String selfname, String surname, String patronymic){
        this.selfname = selfname;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        if (selfname != null && !selfname.isEmpty()) {
            result.append(selfname);
        }

        if (surname != null && !surname.isEmpty()) {
            if (!result.isEmpty()) result.append(" ");
            result.append(surname);
        }

        if (patronymic != null && !patronymic.isEmpty()) {
            if (!result.isEmpty()) result.append(" ");
            result.append(patronymic);
        }

        return result.toString();
    }
}