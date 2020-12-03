package com.example.listviewreal;

public class User {
    String name, phone;
    Sex sex;

    public User(String name, String phone, Sex sex) {
        this.name = name;
        this.phone = phone;
        this.sex = sex;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phone;
    }
}
