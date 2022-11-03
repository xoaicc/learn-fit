package PR1Tutorial.Tut04;

import java.util.Scanner;

public class countDigits {
    public static void main(String[] args) {
        //input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        //output
        if (n > -10 && n < 10) {
            System.out.print("There is a digit");
        } else {
            if (n <= -10) {
                n *= -1;
            }
            int d = 1;
            for (int i = 10; i <= n; i *= 10) {
                d ++;
            }
            System.out.print("There are " + d + " digits");
            
        }
    }
}