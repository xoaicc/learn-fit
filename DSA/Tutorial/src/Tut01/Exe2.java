package Tut01;

import java.util.Scanner;

public class Exe2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount of list: ");
        int N = scanner.nextInt();
        scanner.nextLine();

        int[] nums = new int[N];
        int max = 0;

        System.out.print("Enter the integer list: ");
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
            if (max < nums[i]) max = nums[i];
        }

        System.out.println("The max of list: " + max);
        scanner.close();
    }
}
