package Tut01;

public class Interest {
    public static void main(String[] args) {
        /* Declare the variables. */
        int principal;
        double rate;
        double interest;
        /* Do the computations. */
        principal = 17000;
        rate = 0.07;
        interest = principal * rate;
        principal = (int) (principal + interest);
        /* Output the results. */
        System.out.print("The interest earned is ");
        System.out.println(interest);
        System.out.print("The value of the investment after one year is ");
        System.out.println(principal);
    }
}
