package Tut05;

import java.util.Scanner;

public class Math {
    public static double remainder(double A, double B) {
        while (A > B) A -= B;
        return A;
    }

    public static int div(double A, double B) {
        int C = 0;
        while (A > B) {
            A -= B;
            C++;
        }
        return C;
    }

    public static double middle(double A, double B, double C) {
        if (A > B) {
            if (A < C) return A;
            if (B > C) return B;
            else return C;
        } else {
            if (A > C) return A;
            if (B > C) return C;
            else return B;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 4;
        while (choice != 0) {
            System.out.print("--------------\n" +
                    "Math Menu: \n" +
                    "[0] exit\n" +
                    "[1] remainder\n" +
                    "[2] div\n" +
                    "[3] middle\n" +
                    "Enter: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.print("Enter divisor and division: ");
                    double A1 = scanner.nextDouble();
                    double B1 = scanner.nextDouble();
                    if (B1 != 0)
                        System.out.println("The remainder of " + A1 + " and " + B1 + " is : " + remainder(A1, B1));
                    break;
                case 2:
                    System.out.print("Enter divisor and division: ");
                    double A2 = scanner.nextDouble();
                    double B2 = scanner.nextDouble();
                    if (B2 != 0)
                        System.out.println("The quotient of " + A2 + " and " + B2 + " is : " + div(A2, B2) + " + " + remainder(A2, B2) + "/" + B2);
                    break;
                case 3:
                    System.out.print("Enter three numbers: ");
                    double A3 = scanner.nextDouble();
                    double B3 = scanner.nextDouble();
                    double C3 = scanner.nextDouble();
                    System.out.println("The middle of " + A3 + ", " + B3 + " and " + C3 + " is : " + middle(A3, B3, C3));
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}
