package PR1Tutorial.Tut05;

import java.util.Scanner;

public class Act1 {
    public static void toBinary(int num) {
        int[] bin = new int[35];
        int i = 0;

        while (num > 0) {
            bin[i++] = num % 2;
            num /= 2;
        }

        for (int j = i - 1; j >= 0; j--)
            System.out.print(bin[j]);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        System.out.print("The binary form of this integer is ");
        toBinary(num);
    }
}