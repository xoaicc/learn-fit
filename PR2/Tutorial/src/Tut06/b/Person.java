package Tut06.b;

public class Person {
    public void setName(String name) {
        this.name = name;
    }

    public String greet() {
        return "Hello, " + this.name + "! Your info is in our system.";
    }

    private int id;
    private String name;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
