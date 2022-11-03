package SE1Tutorial.Tut03;

import java.util.ArrayList;
import java.util.Scanner;

public class DivisionImpl {
    /**
     * @requires <pre>
     *      a is not null /\ b is not null /\ a.length <= b.length
     *      /\ for n in b: n!= 0
     * </pre>
     * @effects <pre>
     *  try
     *      if a is null or b is null
     *          throw NullPointerException
     *      else if a.length > b.length
     *          throw IndexOutOfBoundsEXception
     *      else if exist n in b s.t. n == 0
     *          throw ArithmeticException (by Java StdLib)
     *      else
     *          return [d1, d2, ..., dn] s.t. dn = a[n]/b[n]
     *  catch IndexOutOfBoundsException by
     *      ask the user either to quit(Q) or to provide missiong values(P)
     *      if user choose Q:
     *          exit immdediately
     *      else if user choose P:
     *          let user input missing values as another array
     *             caculate with b = b combined with missing values
     *  catch ArithmeticException by
     *      ask the user either to quit(Q) or to provide missiong values(P)
     *      if user choose Q:
     *          exit immdediately
     *      else if user choose P:
     *          let user input missing values as another array
     *             caculate with b = b combined with missing values
     * </pre>
     */
    static void divide(double[] a, double[] b) {
        Scanner scanner = new Scanner(System.in);

        try {
            if (a == null || b == null) {
                throw new NullPointerException();
            } else if (a.length > b.length) {
                throw new IndexOutOfBoundsException();
            } else {
                double[] d = new double[a.length];
                for (int i = 0; i < a.length; i++) {
                    try {
                        if (b[i] == 0) {
                            throw new ArithmeticException();
                        }
                        d[i] = a[i] / b[i];
                    } catch (ArithmeticException ex) {
                        System.out.print("Do you want to (Q)uit or to (P)rovide missing values? ");
                        String answer = scanner.nextLine();
                        if (answer.equals("Q")) {
                            return;
                        } else if (answer.equals("P")) {
                            System.out.print("Re-enter b[" + i + "]: ");
                            double reEntered = Integer.parseInt(scanner.nextLine());
                            d[i] = a[i] / reEntered;
                        }
                    }
                }
                System.out.println();
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.print("Do you want to (Q)uit or to (P)rovide missing values? ");
            String answer = scanner.nextLine();
            if (answer.equals("Q")) {
                return;
            } else if (answer.equals("P")) {
                int numMissing = a.length - b.length;
                System.out.print("Enter the " + numMissing + "missing values");
                String input = scanner.nextLine();
                String[] numbersAsStrings = input.split(",");
                double[] newBArray = new double[a.length];
                for (int i = 0; i < numMissing; i++) {
                    newBArray[i + b.length] = Double.parseDouble(numbersAsStrings[i]);
                }
                divide(a, newBArray);
            }
        }
    }

    public double[] easierDivide(double[] a, double[] b) {
        if (a == null || b == null) {
            throw new NullPointerException("null");
        }
        if (a.length > b.length) {
            throw new IndexOutOfBoundsException("Missing " + (b.length - a.length));
        }
        double[] d = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 0) {
                throw new ArithmeticException("division bt zero at index: " + i);
            }
            d[i] = a[i] / b[i];
        }
        return d;
    }
    
    public static void main(String[] args) {
        divide(
            new double[]{1.0, 2, 3},
            new double[]{1, 2}
        );
    }
}