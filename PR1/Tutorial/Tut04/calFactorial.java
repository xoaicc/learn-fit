package PR1Tutorial.Tut04;

import java.util.Scanner;

public class calFactorial {
    public static void main(String[] args) {
        //input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        //output
        if (num == 0 || num == 1) {
            System.out.println("Factorial = 1");
        } else {
            int n = num;
            for (int i = 1; i < n; i++) {
                num *= i;
            }
            System.out.println("Factorial =  " + num);
        }
    }
}