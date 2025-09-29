public class Human {
    Name fullName;
    Human father;

    public Human(String name){
        this.fullName = new Name(name);;
    }

    public Human(Name fullName){
        this.fullName = fullName;
    }

    public Human(Human father, String name){
        this.father = father;
        this.fullName = new Name(name);;
    }

    public Human(Human father, Name fullName){
        this.fullName = fullName;
        this.father = father;
    }

    public String getSelfname(){
        if (fullName.selfname == null){
            return "Безымянный";
        }
        return fullName.selfname;
    }

    public String getPatronymic(){
        if (fullName != null && fullName.patronymic != null) {
            return fullName.patronymic;
        }
        if (father != null && father.getSelfname() != null && !father.getSelfname().equals("Безымянный")) {
            return father.getSelfname() + "ович";
        }
        return null;
    }

    public String getSurname(){
        if (fullName != null && fullName.surname != null && !fullName.surname.isEmpty()) {
            return fullName.surname;
        }

        if (father != null) {
            String fatherSurname = father.getSurname();
            if (fatherSurname != null && !fatherSurname.isEmpty()) {
                return fatherSurname;
            }
        }

        return "Без фамилии";
    }

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
