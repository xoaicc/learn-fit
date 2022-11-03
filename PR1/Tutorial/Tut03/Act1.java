package PR1Tutorial.Tut03;

import java.util.Scanner;

public class Act1 {
    public static void main(String[] args) {
        Scanner age = new Scanner(System.in);
        System.out.print("What's your age? ");
        int a = age.nextInt();
        
        if (a < 13) {
            System.out.println("Not for kids!");
        } else if (a > 19) {
            System.out.println("You're too old!");
        } else {
            System.out.println("Welcome, teenager!");
        }
    }
}