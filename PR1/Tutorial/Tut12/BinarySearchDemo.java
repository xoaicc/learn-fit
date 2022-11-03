package PR1Tutorial.Tut12;

import java.util.Scanner;

class BinarySearchDemo {
    static int binarySearch (int[] A, int k, int low, int high) {
        if (high < low) return -2;
        else {
            int mid = (low + high) / 2;
            if (A[mid] == k) return mid;
            else if (A[mid] > k) return binarySearch(A, k, low, mid - 1);
            else return binarySearch(A, k, mid + 1, high);
        }
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter array of integers: ");
        String arr = input.nextLine();
        System.out.print("Enter an integer target, low, high: ");
        int k = input.nextInt();
        int low = input.nextInt();
        int high = input.nextInt();
        input.close();

        int[] A = new int[arr.split(" ").length];
        int c = 0;
        for (String i : arr.split(" ")) {
            A[c] = Integer.parseInt(i);
            c++;
        }

        System.out.println("The position of " + k + " in A is: " + (binarySearch(A, k, low - 1, high - 1) + 1));
    }
}