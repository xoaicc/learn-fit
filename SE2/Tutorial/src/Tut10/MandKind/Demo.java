package Tut10.MandKind;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String input2 = scanner.nextLine();
        String[] info = input.split(" ");
        String[] info2 = input2.split(" ");
        try {
            Student student = new Student(info[0], info[1], Integer.parseInt(info[2]));
            System.out.println(student.toString());
            Worker worker = new Worker(info2[0], info2[1], Double.parseDouble(info2[2]), Integer.parseInt(info2[3]));
            System.out.println(worker.toString());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}
