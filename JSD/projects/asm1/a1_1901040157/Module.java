package asm1.a1_1901040157;

import java.util.concurrent.atomic.AtomicInteger;

abstract class Module {
    private String code;
    private final String name;
    private final int seme;
    private final int cred;
    private static final AtomicInteger c1 = new AtomicInteger(100);
    private static final AtomicInteger c2 = new AtomicInteger(200);
    private static final AtomicInteger c3 = new AtomicInteger(300);

    public Module(String name, int semester, int credits) {
        this.name = name;
        this.seme = semester;
        this.cred = credits;
    }

    public void generateCode(int semester) {
        if (semester == 1) {
            c1.incrementAndGet();
            code = "M" + c1;
        } else if (semester == 2) {
            c2.incrementAndGet();
            code = "M" + c2;
        } else {
            c3.incrementAndGet();
            code = "M" + c3;
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return seme;
    }

    public int getCredits() {
        return cred;
    }
}
