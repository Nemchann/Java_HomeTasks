package com.nemchann.training.building;

public class User {
    private final int age;
    private final String address;
    private final String phone;
    private final String name;
    private final String surname;

    private User (UserBuilder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    public static class UserBuilder{
        private int age;
        private String address;
        private String phone;
        private String name;
        private String surname;

        public UserBuilder (String name, String surname){
            this.name = name;
            this.surname = surname;
        }

        public UserBuilder setAge(int age){
            this.age = age;
            return this;
        }
        public UserBuilder setAddress(String address){
            this.address = address;
            return this;
        }
        public UserBuilder setPhone(String phone){
            this.phone = phone;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
