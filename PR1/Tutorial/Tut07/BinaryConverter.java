package PR1Tutorial.Tut07;

import java.util.Scanner;

public class BinaryConverter {
    static int[] bin = new int[35];
    static int i = 0;

    static int binary(int num) {
        bin[i] = num % 2;
        num /= 2;
        i++;
        if (num != 0) return binary(num);
        else return 1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = input.nextInt();
        binary(num);
        System.out.print("The binary form of this integer is: ");
        for (int j = i-1; j >= 0; j--)
            System.out.print(bin[j]);
    }
}