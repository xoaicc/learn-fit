package Tut10.Person;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Age: %d",
                this.getName(), this.getAge()));
        return sb.toString();
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        if (name.split(" ").length > 3) throw new IllegalArgumentException("Name's length should be less than 3 symbols!");
        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) throws IllegalArgumentException {
        if (age < 1) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }
}
