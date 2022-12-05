package asm1.a1_1901040157;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Calendar;

public class Student {
    private final String id;
    private final String name;
    private final int dob;
    private final String addr;
    private final String email;
    private static final AtomicInteger count = new AtomicInteger(Calendar.getInstance().get(Calendar.YEAR));

    public Student(String name, int dob, String address, String email) {
        id = "S" + count.getAndIncrement();
        this.name = name;
        this.dob = dob;
        this.addr = address;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDob() {
        return dob;
    }

    public String getAddr() {
        return addr;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id:'" + getId() + '\'' +
                ", name:'" + getName() + '\'' +
                ", dob:" + getDob() +
                ", address:'" + getAddr() + '\'' +
                ", email:'" + getEmail() + '\'' +
                '}';
    }
}