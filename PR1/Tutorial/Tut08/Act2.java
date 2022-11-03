package PR1Tutorial.Tut08;

import java.util.Scanner;

public class Act2 {
    private static int sumWithoutSmallest(int[] intArray) {
        int sum = intArray[0], min = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            sum += intArray[i];
            if (min > intArray[i]) min = intArray[i];
        }
        return sum - min;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter quantity of numbers: ");
        int quantity = input.nextInt();
        input.nextLine();
        System.out.print("Enter array of " + quantity + " numbers: ");
        int[] intArray = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            intArray[i] = input.nextInt();
        }
        System.out.print("The sum of your array without smallest number is " + sumWithoutSmallest(intArray));
    }
}