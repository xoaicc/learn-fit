package asm2.a2_1901040247;

public class Enrolment {
    private final Student student;
    private final Module module;
    private double internalMark;
    private double examMark;
    private char finalGrade;

    public Enrolment(Student student, Module module) {
        this.student = student;
        this.module = module;
    }

    public Student getStudent() {
        return student;
    }

    public Module getModule() {
        return module;
    }

    public void setInternalMark(double internalMark) {
        this.internalMark = internalMark;
    }

    public void setExamMark(double examMark) {
        this.examMark = examMark;
    }

    public char getFinalGrade() {
        calculateMark();
        return finalGrade;
    }

    public void calculateMark() {
        double aggregatedMark = internalMark * 0.4 + examMark * 0.6;

        if (aggregatedMark < 5) finalGrade = 'F';
        else if (aggregatedMark < 8) finalGrade = 'P';
        else if (aggregatedMark < 9) finalGrade = 'G';
        else finalGrade = 'E';
    }

    @Override
    public String toString() {
        return "Enrolment{" +
                "student=" + student.toString() +
                ", module=" + module.toString() +
                ", internalMark=" + internalMark +
                ", examMark=" + examMark +
                ", finalGrade=" + getFinalGrade() +
                '}';
    }
}