package Tut04;

import java.util.Scanner;

public class Exe1 {
    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the nums of list: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the integer " + (i+1) + ": ");
            A[i] = scanner.nextInt();
        }

        scanner.close();
        // End Input

        // Algorithm | O(n^2)
        for (int i = 0; i < n-1; i++) {
            int min = A[i], p = i;

            for (int j = i+1; j < n; j++) {
                if (A[j] < min) {
                    min = A[j];
                    p = j;
                }
            }

            A[p] = A[i];
            A[i] = min;
        }
        // End Algorithm

        // Output
        System.out.print("The re-arrange is: ");

        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }
        // End Output
    }
}
