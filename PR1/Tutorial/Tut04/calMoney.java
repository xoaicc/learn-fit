package PR1Tutorial.Tut04;

import java.util.Scanner;

public class calMoney {
    public static void main(String[] args) {
        //input
        Scanner input = new Scanner(System.in);
        System.out.print("How many years do you want to deposit your money? ");
        short year = input.nextShort();
        System.out.print("How much money? ");
        double money = input.nextDouble();
        System.out.print("What's the interest rate (%)? ");
        float rate = input.nextFloat();
        //output
        for (int i = 0; i < year; i++) {
            money += (money * rate / 100);
        }
        System.out.printf("After %d years, you'll receive %.2f", year, money);
    }
}