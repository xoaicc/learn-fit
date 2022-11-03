package Tut01;

import java.util.Scanner;

public class Exe3 {
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

        System.out.print("The ascending list: ");
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (nums[i] > nums[j]) {
                    int k = nums[j];
                    nums[j] = nums[i];
                    nums[i] = k;
                }
            }
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[N-1]);

        scanner.close();
    }
}
