package Tut10;

public class Fibonacci {
    /**
     * @effects
     *   if n <= 1 then roll back
     *   else
     *      call again with n-1 and n-2
     */
    public static int Sum(int n) {
        if (n <= 1) return n;
        else return Sum(n-1) + Sum(n-2);
    }
    
    public static void main(String[] args) {
        System.out.print(Sum(9));
    }
}
