package PR1Tutorial.Tut04;

import java.util.Scanner;

public class printFibonacci {
    public static void main(String[] args) {
        //input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Fibo limit: ");
        int n = input.nextInt();
        //output
        int fi1 = 0;
        int fi2 = 1;
        int fi0;
        System.out.print("The Fibo array: 0 1 ");
        for (int i = 2; i < n; i++) {
            fi0 = fi2;
            fi2 += fi1;
            fi1 = fi0;
            System.out.print(fi2 + " ");
        }
    }
}