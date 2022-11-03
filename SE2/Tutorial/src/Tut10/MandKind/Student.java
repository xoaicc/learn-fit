package Tut10.MandKind;

public class Student extends Human {
    private int facultyNumber;

    public Student(String firstName, String lastName, int facultyNumber) {
        super(firstName, lastName);
        setFacultyNumber(facultyNumber);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("First Name: ").append(this.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(this.getLastName())
                .append(System.lineSeparator())
                .append("Faculty Number: ").append(this.getFacultyNumber())
                .append(System.lineSeparator());
        return sb.toString();
    }

    protected int getFacultyNumber() {
        return facultyNumber;
    }

    protected void setFacultyNumber(int facultyNumber) {
        if (facultyNumber >= 5 && facultyNumber <= 10)
            throw new IllegalArgumentException("Invalid faculty number!");
        this.facultyNumber = facultyNumber;
    }
}
