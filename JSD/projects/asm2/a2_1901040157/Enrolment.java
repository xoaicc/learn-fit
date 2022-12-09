package a2_1901040157;

public class Enrolment {
    private final String stuID;
    private final String modCode;
    private double inMark;
    private double exMark;

    public Enrolment(String stuID, String modCode) {
        this.stuID = stuID;
        this.modCode = modCode;
    }

    public String getStuID() {
        return stuID;
    }

    public String getModCode() {
        return modCode;
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

    public char getFiGrade() {
        return calculateMark();
    }

    public char calculateMark() {
        double sum = inMark * 0.4 + exMark * 0.6;

        if (sum < 5) return 'F';
        else if (sum < 8) return 'P';
        else if (sum < 9) return 'G';
        else return 'E';
    }
}