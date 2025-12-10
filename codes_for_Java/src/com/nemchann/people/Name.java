package com.nemchann.people;

public class Name {
    String surname;
    final String selfname;
    String patronymic;

//    public Name(String selfname){
//        this(selfname, null, null);
//    }
//
//    public Name(String selfname, String surname){
//        this(selfname, surname, null);
//    }

    private Name(String selfname, String surname, String patronymic){

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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private String surname;
        private String selfname;
        private String patronymic;

        private Builder(){
            this.surname = null;
            this.selfname = null;
            this.patronymic = null;
        }

        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder selfname(String selfname){
            this.selfname = selfname;
            return this;
        }

        public Builder patronymic(String patronymic){
            this.patronymic = patronymic;
            return this;
        }

        public Name build() {
            return new Name(selfname, surname, patronymic);
        }
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