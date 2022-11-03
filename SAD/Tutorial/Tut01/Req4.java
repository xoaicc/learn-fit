package SADTutorial.Tut01;

class Student {
    private String studentId;
    private String studentName;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
    public String getStudentId() {
        return this.studentId;
    }
    public String getStudentName() {
        return this.studentName;
    }
}

class Course {
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
    public String getCourseCode() {
        return this.courseCode;
    }
    public String getCourseName() {
        return this.courseName;
    }
}

class Enrolment {
    Student student;
    Course course;
    int attendanceMark;
    float midtermMark;
    float finalMark;

    public Enrolment(Student student, Course course, int attendanceMark, float midtermMark, float finalMark) {
        this.student = student;
        this.course = course;
        this.attendanceMark = attendanceMark;
        this.midtermMark = midtermMark;
        this.finalMark = finalMark;
    }
    public double OverallMark() {
        return (this.attendanceMark * 0.1 + this.midtermMark * 0.3 + this.finalMark * 0.6);
    }
    public int getAttendanceMark() {
        return attendanceMark;
    }
    public float getMidtermMark() {
        return midtermMark;
    }
    public float getFinalMark() {
        return finalMark;
    }
    @Override
    public String toString() {
        return String.format("Student %s whose id is %s got attendance mark = %d, midterm = %f and final = %f. Overall is %f", student.getStudentName(), student.getStudentId(), attendanceMark, midtermMark, finalMark, OverallMark());
    }
}

public class Req4 {
    public static void main(String[] args) {
        Student student1 = new Student("1901040247", "Do Minh Vuong");
        Student student2 = new Student("1901020427", "Le Tran Thanh");
        Student student3 = new Student("1924020434", "Nguyen Quang Hai");

        Course course1 = new Course("PR1", "Program 1");
        Course course2 = new Course("PR2", "Program 2");
        Course course3 = new Course("PR3", "Program 3");

        Enrolment enrolment1 = new Enrolment(student1, course1, 8, 9, 7);
        System.out.println(enrolment1);
        Enrolment enrolment2 = new Enrolment(student2, course2, 10, 6, 9);
        System.out.println(enrolment2);
        Enrolment enrolment3 = new Enrolment(student3, course3, 9, 7, 8);
        System.out.println(enrolment3);
    }
}