package PR1Tutorial.Tut07;

import java.util.Scanner;

public class NumberPrinter {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an integer between 1000 and 999999: ");
        int num = input.nextInt();
        if (num < 1000 || num > 999999) {
            throw new Exception("Your number is out of range!");
        }
        String numStr = String.valueOf(num);
        numStr = new StringBuffer(numStr).insert(numStr.length()-3, ",").toString();
        System.out.println(numStr);
    }
}