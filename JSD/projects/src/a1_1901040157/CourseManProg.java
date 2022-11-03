package a1_1901040157;

public class CourseManProg {
    public static void main(String[] args) {
        // Initialise module
        CompulsoryModule module1 = new CompulsoryModule("Programming 1", 1, 5);
        CompulsoryModule module2 = new CompulsoryModule("Data Mining", 3, 3);
        CompulsoryModule module3 = new CompulsoryModule("Programming 2", 2, 2);
        ElectiveModule module4 = new ElectiveModule("Project Manager", 1, 2, "FIT");
        ElectiveModule module5 = new ElectiveModule("Software Engineer 2", 3, 3, "FIT");

        // Initialise student
        Student student1 = new Student("Hong Hanh", 2002, "Hai Phong", "1901040223@s.hanu.edu.vn");
        Student student2 = new Student("Ngan Phuc", 2000, "Bing Duong", "1901040761@s.hanu.edu.vn");
        Student student3 = new Student("Thuy Trang", 2001, "Ben Tre", "1901040157@ms.hanu.edu.vn");
        Student student4 = new Student("Duc Giang", 2002, "Ha Giang", "1901042347@s.hanu.edu.vn");
        Student student5 = new Student("Vu Duc", 2001, "Vinh Phuc", "1901040233@ms.hanu.edu.vn");

        // Initialise enrolmentManager
        EnrolmentManager enrolMan1 = new EnrolmentManager();

        enrolMan1.addEnrolment(new Enrolment(student2, module4));
        enrolMan1.addEnrolment(new Enrolment(student3, module3));
        enrolMan1.addEnrolment(new Enrolment(student4, module2));
        enrolMan1.addEnrolment(new Enrolment(student2, module5));
        enrolMan1.addEnrolment(new Enrolment(student1, module4));
        enrolMan1.addEnrolment(new Enrolment(student2, module1));
        enrolMan1.addEnrolment(new Enrolment(student5, module1));
        enrolMan1.addEnrolment(new Enrolment(student1, module3));
        enrolMan1.addEnrolment(new Enrolment(student3, module2));
        enrolMan1.addEnrolment(new Enrolment(student4, module4));

        // Print a non-sorted initial report
        System.out.println("The non-sorted initial report of the enrolments: \n" + enrolMan1.report());

        // Print a sorted initial report
        enrolMan1.sort();
        System.out.println("The sorted initial report of the enrolments: \n" + enrolMan1.report());

        // Initialise and enter marks for 5 enrols
        EnrolmentManager enrolMan2 = new EnrolmentManager();

        enrolMan2.addEnrolment(new Enrolment(student4, module5));
        enrolMan2.addEnrolment(new Enrolment(student2, module4));
        enrolMan2.addEnrolment(new Enrolment(student5, module1));
        enrolMan2.addEnrolment(new Enrolment(student1, module4));
        enrolMan2.addEnrolment(new Enrolment(student2, module3));

        enrolMan2.setMarks(student4, module5, 3.0, 6.5);
        enrolMan2.setMarks(student2, module4, 6.0, 7.5);
        enrolMan2.setMarks(student5, module1, 6.5, 4.5);
        enrolMan2.setMarks(student1, module4, 7.0, 6.5);
        enrolMan2.setMarks(student2, module3, 9.5, 8.5);

        // Print a sorted assessment report
        enrolMan2.sort();
        System.out.println("The sorted assessment report of the enrolments: \n" + enrolMan2.reportAssessment());
        System.out.print("---------------\n      End");
    }
}
