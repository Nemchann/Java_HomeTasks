class Name {
    String surname;
    String selfname;
    String patronymic;


    public String toString() {
        StringBuilder result = new StringBuilder();

        if (surname != null && !surname.isEmpty()) {
            result.append(surname);
        }

        if (patronymic != null && !patronymic.isEmpty()) {
            if (!result.isEmpty()) result.append(" ");
            result.append(patronymic);
        }
        
        if (selfname != null && !selfname.isEmpty()) {
            if (!result.isEmpty()) result.append(" ");
            result.append(selfname);
        }

        return result.toString();
    }
}