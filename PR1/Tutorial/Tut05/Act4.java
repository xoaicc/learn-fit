package PR1Tutorial.Tut05;

import java.util.Scanner;

public class Act4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print("*");
            }
            System.out.print(" ");
            for (int k = 0; k < num; k++) {
                if (i != 0 && i != (num - 1) && k != 0 && k != (num - 1))
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println("");
        }
    }
}