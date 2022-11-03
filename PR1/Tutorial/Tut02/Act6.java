package PR1Tutorial.Tut02;

import java.util.Scanner;

public class Act6 {
    public static void main(String[] args) {
        Scanner getData = new Scanner(System.in);
        System.out.print("Enter year: ");
        int y = getData.nextInt();

        System.out.print("Enter month (1-12): ");
        int m = getData.nextInt();

        System.out.print("Enter the day of the month (1-31): ");
        int q = getData.nextInt();

        int k = y % 100;
        int j = y / 100;
        int h = (q + (26 * (m + 1))/10 + k + k / 4 + j / 4 + 5 * j) % 7;
        switch(h) {
            case 0:
            System.out.println("Day of the week is " + "Saturday");
            break;
            case 1:
            System.out.println("Day of the week is " + "Sunday");
            break;
            case 2:
            System.out.println("Day of the week is " + "Monday");
            break;
            case 3:
            System.out.println("Day of the week is " + "Tuesday");
            break;
            case 4:
            System.out.println("Day of the week is " + "Wednesday");
            break;
            case 5:
            System.out.println("Day of the week is " + "Thursday");
            break;
            case 6:
            System.out.println("Day of the week is " + "Friday");
            break;
        }
    }
}