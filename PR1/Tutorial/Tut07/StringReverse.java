package PR1Tutorial.Tut07;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        char[] ch = str.toCharArray();
        String rev = "";
        for(int i=ch.length-1; i>=0; i--) {  
            rev += ch[i];
        }
        System.out.print("The reverse string is: ");
        System.out.println(rev);
    }
}