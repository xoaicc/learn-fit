package Tut02;

import java.util.Scanner;

public class Exe1 {
    // O(n/2)
    public static int Search(int [] a, int m) {
        for (int i = 0; i < a.length; i+=2)
            if (i == (a.length - 1)) {
                if (a[i] == m) {
                    return i;
                } else {
                    return -1;
                }
            } else {
                if ((a[i] + a[i + 1]) >= m) {
                    if (a[i] == m) {
                        return i;
                    } else if (a[i + 1] == m) {
                        return i + 1;
                    }
                }
            }
        return -1;
    }

    public static void main(String[] args) {
        int n, m;
        int[] a;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers of array: ");
        n = scanner.nextInt();
        scanner.nextLine();

        a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter the integer a[" + i + "]: ");
            a[i] = scanner.nextInt();
        }

        System.out.print("Enter the integer m for searching: ");
        m = scanner.nextInt();

        scanner.close();

        System.out.println("The search result is: " + Search(a, m));
    }
}
