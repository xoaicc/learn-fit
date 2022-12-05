package asm1.a1_1901040157;

public class Enrolment {
    private final Module mod;
    private final Student stu;
    private double inMark;
    private double exMark;

    public Enrolment(Student student, Module module) {
        this.stu = student;
        this.mod = module;
    }

    public Student getStudent() {
        return stu;
    }

    public Module getModule() {
        return mod;
    }

    public void setInternalMark(double internalMark) {
        this.inMark = internalMark;
    }

    public void setExamMark(double examMark) {
        this.exMark = examMark;
    }

    public double getInMark() {
        return inMark;
    }

    public double getExMark() {
        return exMark;
    }

    public char getFinalGrade() {
        return calculateMark();
    }

    public char calculateMark() {
        double sum = inMark * 0.4 + exMark * 0.6;

        if (sum < 5) return 'F';
        else if (sum < 8) return 'P';
        else if (sum < 9) return 'G';
        else return 'E';
    }

    @Override
    public String toString() {
        return "Enrolment{" +
                "student:" + stu.toString() +
                ", module:" + mod.toString() +
                ", internalMark:" + getInMark() +
                ", examMark:" + getExMark() +
                ", finalGrade:" + getFinalGrade() +
                '}';
    }
}