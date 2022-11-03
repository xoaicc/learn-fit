package PR1Tutorial.Tut03;

import java.util.Scanner;

public class Act4 {
    public static void main(String[] args) {
        Scanner num10 = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        String num = num10.nextLine();
        
        int n = Integer.parseInt(num);
        int c = 100000000;
        int x = 0;
        for (int i = 1; i < 10; i++) {
            x += (int)(n / c) * i;
            n = n % c;
            c /= 10;
        }

        if ((x % 11) == 10) {
            System.out.println("The ISBN-10 number is " + num + "x");
        } else {
            System.out.println("The ISBN-10 number is " + num + (x % 11));
        }
    }
}