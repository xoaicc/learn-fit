package Tut04;

import java.util.Scanner;

public class Exe3 {
    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the nums of list: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        int[] A = new int[n];
        int max = 0, min = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the integer " + (i+1) + ": ");
            A[i] = scanner.nextInt();
            if (A[i] > max) max = A[i];
            if (A[i] < min) min = A[i];
        }

        scanner.close();
        //End Input

        // Algorithm | O(n)
        int[] B = new int[Math.abs(min)+1], C = new int[max+1];

        for (int i = 0; i < n; i++) {
            if (A[i] < 0) B[Math.abs(A[i])] ++;
            else C[A[i]] ++;
        }
        // End Algorithm

        // Output
        System.out.print("The re-arrange is: ");

        for (int i = B.length-1; i > 0; i--) {
            for (int j = 0; j < B[i]; j++) {
                System.out.print("-" + i + " ");
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i]; j++) {
                System.out.print(i + " ");
            }
        }
        // End Output
    }
}
