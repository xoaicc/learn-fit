package PR1Tutorial.Tut12;

import java.util.Scanner;

class SelectionSortDemo {
    static int[] selectionSort (int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int p = i;
            for (int j = i+1; j < A.length; j++) if (A[j] < A[p]) {
                p = j;
            }
            B[i] = A[p];
            A[p] = A[i];
        }
        return B;
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter array of integers: ");
        String arr = input.nextLine();
        input.close();

        int[] A = new int[arr.split(" ").length];
        int c = 0;
        for (String i : arr.split(" ")) {
            A[c] = Integer.parseInt(i);
            c++;
        }

        System.out.print("The array A after sort is: ");
        for (int i : selectionSort(A)) System.out.print(i + " ");
    }
}