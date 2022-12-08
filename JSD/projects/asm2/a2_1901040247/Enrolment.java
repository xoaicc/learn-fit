package a2_1901040247;

public class Enrolment {
    private Student student;
    private Module module;
    private String studentID;
    private String moduleCODE;
    private double internalMark;
    private double examMark;
    private char finalGrade;

    public Enrolment(Student student, Module module) {
        this.student = student;
        this.module = module;
    }

    public Enrolment(String studentID, String moduleCODE) {
        this.studentID = studentID;
        this.moduleCODE = moduleCODE;
    }

    public Student getStudent() {
        return student;
    }

    public Module getModule() {
        return module;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getModuleCODE() {
        return moduleCODE;
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