package asm2.a2_1901040247;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    private static final AtomicInteger count = new AtomicInteger(
            Calendar.getInstance().get(Calendar.YEAR));
    private final String id;
    private final String name;
    private final int dob;
    private final String address;
    private final String email;

    public Student(String name, int dob, String address, String email) {
        id = "S" + count.getAndIncrement();
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}