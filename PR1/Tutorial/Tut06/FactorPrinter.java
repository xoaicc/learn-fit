package PR1Tutorial.Tut06;

import java.util.Scanner;

public class FactorPrinter {
    public static void main(String[] args) {
        // Get input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int numIn = input.nextInt();

        // Run printer
        FactorGenerator factor = new FactorGenerator(numIn);
        if (numIn < 4) System.out.println(numIn);
        else while (factor.hasMoreFactors()) {
            System.out.print(factor.nextFactor() + " ");
        }
    }
}