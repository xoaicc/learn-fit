package Tut06.a;

import Tut06.a.MobilePhone;

public class Person {
    public void setName(String name) {
        this.name = name;
    }

    public String greet() {
        return "Hello, " + this.name + "! Your info is in our system.";
    }

    private int id;
    private String name;
    private MobilePhone phone;

    public Person (int id, String name, MobilePhone phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
