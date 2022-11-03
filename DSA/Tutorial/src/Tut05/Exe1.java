package Tut05;

import java.util.Scanner;

public class Exe1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] students = new String[11];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name and mark of " + (i+1) + ": ");
            String name = scanner.next();
            students[i] += name + ", ";
        }
        System.out.print("Enter numbers of students: ");
    }
}
