package a1_1901040247;

public class CourseManProg {
    public static void main(String[] args) {
        // Initialise module
        CompulsoryModule module1 = new CompulsoryModule(
                "Java Software Development", 1, 2);
        CompulsoryModule module2 = new CompulsoryModule(
                "System Analysis & Design", 2, 3);
        CompulsoryModule module3 = new CompulsoryModule(
                "Image Processing & Recognition", 1, 5);
        ElectiveModule module4 = new ElectiveModule(
                "Software Project Management", 1, 3,
                "FIT");
        ElectiveModule module5 = new ElectiveModule("Special Subject 2",
                2, 3, "FMT");

        // Initialise student
        Student student1 = new Student("Vuong Do", 2001,
                "Ha Noi", "1901040247@s.hanu.edu.vn");
        Student student2 = new Student("Vuong Le", 2002,
                "Ho Chi Minh", "1901040247@s.hanu.edu.vn");
        Student student3 = new Student("Vuong Nguyen", 2000,
                "Can Tho", "1901040247@s.hanu.edu.vn");
        Student student4 = new Student("Vuong Ho", 2003,
                "New York", "1901040247@s.hanu.edu.vn");
        Student student5 = new Student("Vuong Dinh", 2002,
                "Lao Cai", "1901040247@s.hanu.edu.vn");

        // Initialise enrolmentManager
        EnrolmentManager enrolManager1 = new EnrolmentManager();

        enrolManager1.addEnrolment(new Enrolment(student1, module2));
        enrolManager1.addEnrolment(new Enrolment(student1, module4));
        enrolManager1.addEnrolment(new Enrolment(student2, module1));
        enrolManager1.addEnrolment(new Enrolment(student2, module2));
        enrolManager1.addEnrolment(new Enrolment(student3, module4));
        enrolManager1.addEnrolment(new Enrolment(student3, module5));
        enrolManager1.addEnrolment(new Enrolment(student4, module3));
        enrolManager1.addEnrolment(new Enrolment(student4, module1));
        enrolManager1.addEnrolment(new Enrolment(student5, module3));
        enrolManager1.addEnrolment(new Enrolment(student5, module5));

        // Print a non-sorted initial report
        System.out.println("Non-sorted initial report of the enrolments: \n"
                + enrolManager1.report());

        // Print a sorted initial report
        enrolManager1.sort();
        System.out.println("Sorted initial report of the enrolments: \n"
                + enrolManager1.report());

        // Initialise and enter marks for 5 enrols
        EnrolmentManager enrolManager2 = new EnrolmentManager();

        enrolManager2.addEnrolment(new Enrolment(student2, module2));
        enrolManager2.addEnrolment(new Enrolment(student3, module4));
        enrolManager2.addEnrolment(new Enrolment(student1, module4));
        enrolManager2.addEnrolment(new Enrolment(student4, module3));
        enrolManager2.addEnrolment(new Enrolment(student3, module1));

        enrolManager2.setMarks(student2, module2, 6.0, 7.5);
        enrolManager2.setMarks(student3, module4, 9.0, 9.5);
        enrolManager2.setMarks(student1, module4, 6.0, 8.5);
        enrolManager2.setMarks(student4, module3, 4.0, 5.5);
        enrolManager2.setMarks(student3, module1, 6.5, 9.0);

        // Print a sorted assessment report
        enrolManager2.sort();
        System.out.println("Sorted assessment report of the enrolments: \n"
                + enrolManager2.reportAssessment());

        // End
        System.out.print("The end!\n--------");
    }
}
