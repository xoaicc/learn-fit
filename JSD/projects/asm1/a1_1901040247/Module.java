package asm1.a1_1901040247;

import java.util.concurrent.atomic.AtomicInteger;

abstract class Module {
    private static final AtomicInteger count1 = new AtomicInteger(100);
    private static final AtomicInteger count2 = new AtomicInteger(200);
    private static final AtomicInteger count3 = new AtomicInteger(300);
    private String code;
    private final String name;
    private final int semester;
    private final int credits;

    public Module(String name, int semester, int credits) {
        this.name = name;
        this.semester = semester;
        this.credits = credits;
    }

    public void generateCode(int semester) {
        if (semester == 1) {
            count1.incrementAndGet();
            code = "M" + count1;
        }if (semester == 2) {
            count2.incrementAndGet();
            code = "M" + count2;
        }if (semester == 3) {
            count3.incrementAndGet();
            code = "M" + count3;
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public int getCredits() {
        return credits;
    }
}
