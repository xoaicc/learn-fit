package Tut01;

public class Array {
    public static void main(String[] args) {
        /* Declare the variables. */
        int[] nums = { 2, 0, 1, 3 };
        /* Do some operations on array */
        int sum1 = 0, sum2 = 0, i;
        int n;
        for (i = 0; i < 4; i++) {
            n = nums[i];
            System.out.printf("nums[%d] = %d%n", i, n);
            if ((n % 2) == 0) sum1 += n;
            else sum2 += n;
        }
        System.out.println("Even sum: " + sum1);
        System.out.print("Odd sum: " + sum2);
    } // end of main()
}
