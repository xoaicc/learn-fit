package PR1Tutorial.Tut03;

import java.util.Scanner;

public class Act2 {
    public static void main(String[] args) {
        Scanner year = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int y = year.nextInt();
        if (y % 4 != 0) {
            System.out.println("The year " + y + " is not a leap year");
        } else {
            if (y % 100 != 0) {
                System.out.println("The year " + y + " is a leap year");
            } else {
                if (y % 400 != 0) {
                    System.out.println("The year " + y + " is not a leap year");
                } else {
                    System.out.println("The year " + y + " is a leap year");
                }
            }
        }
    }
}