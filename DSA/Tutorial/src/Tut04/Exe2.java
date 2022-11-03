package Tut04;

import java.util.HashMap;
import java.util.Scanner;

public class Exe2 {
    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the nums of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<Integer, String> stds = new HashMap<>();
        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of student " + (i+1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter the mark of student " + (i+1) + ": ");
            marks[i] = scanner.nextInt();
            scanner.nextLine();

            stds.put(marks[i], name);
        }

        System.out.print("Enter the max students to find: ");
        int m = scanner.nextInt();

        scanner.close();
        // End Input

        // Algorithm + Output
        System.out.print("The " + m + " students who has highest max is: ");

        for (int i = 0; i < m; i++) {
            int max = marks[0], p = 1;

            for (int j = 1; j < n; j++) {
                if (marks[j] > max) {
                    max = marks[j];
                    p = j;
                }
            }

            marks[p] = 0;

            System.out.print(stds.get(max) + " ");
        }
        // End Algorithm + Output
    }
}
