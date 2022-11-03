package PR1Tutorial.Tut03;

import java.util.Scanner;

public class Act3 {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.print("Please enter a: ");
        int a = num.nextInt();
        System.out.print("Please enter b: ");
        int b = num.nextInt();
        System.out.print("Please enter c: ");
        int c = num.nextInt();

        if (a == 0 && b == 0 && c == 0) {
            System.out.println("These numbers are not correct!");
        } else if (a == 0 && b == 0) {
            System.out.println("The equation has no root!");
        } else if (a == 0) {
            System.out.println("There is one root: " + (-c / b));
        } else {
            if ((b * b - 4 * a * c) < 0) {
                System.out.println("The equation has no real root!");
            } else {
                System.out.println("There are two root:\nx1 = " + ((-b + Math.sqrt(b * b - 4 * a * c)) / 2 / a) + ", x2 = " + ((-b - Math.sqrt(b * b - 4 * a * c)) / 2 / a));
            }
        }
    }
}