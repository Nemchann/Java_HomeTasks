class Name {
    String surname;
    final String selfname;
    String patronymic;

    public Name(String selfname){
        this(selfname, null, null);
    }

    public Name(String selfname, String surname){
        this(selfname, surname, null);
    }

    public Name(String selfname, String surname, String patronymic){

        boolean hasValidSelfname = selfname != null && !selfname.isEmpty();
        boolean hasValidSurname = surname != null && !surname.isEmpty();
        boolean hasValidPatronymic = patronymic != null && !patronymic.isEmpty();

        if (!hasValidSelfname && !hasValidSurname && !hasValidPatronymic) {
            throw new IllegalArgumentException("At least one of the parameters must be not null and not empty");
        }

        this.selfname = selfname;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getSelfname() {
        return selfname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
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