package a2_1901040247;

public class Enrolment {
    private final String studentID;
    private final String moduleCODE;
    private double internalMark;
    private double examMark;
    private char finalGrade;

    public Enrolment(String studentID, String moduleCODE) {
        this.studentID = studentID;
        this.moduleCODE = moduleCODE;
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
}