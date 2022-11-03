package PR1Tutorial.Tut08;

import java.util.Arrays;
import java.util.Scanner;

public class Act4 {
    static int[] lastDigit = new int[10];
    
    private static int[] countLastDigits(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            lastDigit[intArray[i] % 10]++;
        }
        return lastDigit;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the quantity of numbers: ");
        int quantity = input.nextInt();
        input.nextLine();
        int[] intArray = new int[quantity];
        System.out.print("Enter the array of " + quantity + " numbers: ");
        for (int i = 0; i < quantity; i++) {
            intArray[i] = input.nextInt();
        }
        System.out.print("The array contains count of last digits are: ");
        System.out.print(Arrays.toString(countLastDigits(intArray)));
    }
}