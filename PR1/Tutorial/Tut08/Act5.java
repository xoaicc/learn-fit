package PR1Tutorial.Tut08;

import java.util.Arrays;
import java.util.Scanner;

public class Act5 {
    private static int[] shiftRight(int[] intArray) {
        int[] intArray2 = new int[intArray.length];
        intArray2[0] = intArray[intArray.length-1];
        for (int i = 0; i < intArray.length-1; i++) {
            intArray2[i+1] = intArray[i];
        }
        return intArray2;
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
        System.out.print("The array after shift right is: ");
        System.out.print(Arrays.toString(shiftRight(intArray)));
    }
}