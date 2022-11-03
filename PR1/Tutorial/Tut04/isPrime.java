package PR1Tutorial.Tut04;

import java.util.Scanner;

public class isPrime {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = num.nextInt();
        if (n > 2) {
            for (int i = 2; i <= (int)Math.sqrt(n); i++) {
                if (n % i == 0) {
                    System.out.println("It is not a prime number.");
                    break;
                }
                if (i == (int)Math.sqrt(n)) {
                    System.out.println("It is a prime number.");
                }
            }
        } else if (n == 2) {
            System.out.println("It is a prime number.");
        } else {
            System.out.println("It is not a prime number.");
        }
    }
}