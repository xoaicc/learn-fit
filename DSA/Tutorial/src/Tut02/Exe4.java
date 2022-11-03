package Tut02;

import java.util.Scanner;

public class Exe4 {
    public static int GCD(int m, int n) {
        int i = 2;

        while (i <= n) {
            if ((m % n) == 0) return n;
            if ((n % i) == 0) n /= i;
            i++;
        }

        return 1;
    }

    public static void main(String[] args) {
        int m,n;

        System.out.print("Enter the integer m: ");
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the integer n (n<=m): ");
        n = scanner.nextInt();

        scanner.close();

        System.out.println("The gcd("+ m + ", " + n + ") is: " + GCD(m,n));
    }
}
