package tutes.oop3;

public class SingleThreaded {
    /**
     *
     * @effects return the number of divisors of n
     *          from 2 up to n -1
     */
    public static int countDivisors(int n) {
        int count =0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) count++;
        }
        return count;
    }

    /**
     *
     * @effect find & display the integer between a and 20,000
     *          which has the largest number of divisors
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int maxDivisorCount = 0;
        int theAssociatedNumber = 0;
        for (int N = 1; N < 200000; N++) {
            int count = countDivisors(N);
            if (count > maxDivisorCount) {
                maxDivisorCount = count;
                theAssociatedNumber = N;
            }
        }
        System.out.println(theAssociatedNumber + "has the most divisors between 1 and 20000");
        System.out.println("It has " + maxDivisorCount + " divisors");
        long finishTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + String.format("%.2f", (finishTime - startTime) / 1000.0) + "s");
    }
}
