package Tut02;

import java.util.Scanner;

public class Exe3 {
    // O(n/2)
    public static double Pow(double x, int n) {
        double s = 1;

        if (n == 0) return s;

        for (int i = 1; i <= n; i+=2)
            if (i == n) s *= x;
            else s *= (x * x);

        return s;
    }

    public static void main(String[] args) {
        double x;
        int n;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of x & degree n: ");
        x = scanner.nextDouble();
        n = scanner.nextInt();

        scanner.close();

        System.out.println("The value of (" + x + ")^" + n + " is: " + Pow(x,n));
    }
}
