public class Human {
    Name fullName;
    Human father;

    public String toString() {
        StringBuilder result = new StringBuilder("Человек с именем");

        if (fullName != null) {
            if (fullName.surname == null && father != null && father.fullName != null) {
                result.append(" ").append(father.fullName.surname);
            } else if (fullName.surname != null) {
                result.append(" ").append(fullName.surname);
            }

            if (fullName.selfname != null) {
                result.append(" ").append(fullName.selfname);
            }

            if (fullName.patronymic == null) {
                if (father != null && father.fullName != null && father.fullName.selfname != null) {
                    result.append(" ").append(father.fullName.selfname).append("ович");
                }
            } else {
                result.append(" ").append(fullName.patronymic);
            }
        }

        return result.toString();
    }
}
