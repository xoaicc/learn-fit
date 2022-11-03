package PR1Tutorial.Tut04;

import java.util.Scanner;

public class isPalindrome {
    public static void main(String[] args) {
        //input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number to check: ");
        String num = input.nextLine();
        //output
        String mun = new StringBuffer(num).reverse().toString();
        if (num.equals(mun)) {
            System.out.println("This is a Palindrome!");
        } else {
            System.out.println("This is not a Palindrome!");
        }
    }
}