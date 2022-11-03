package Tut08;

import java.util.Scanner;

public class Exe1 {
    public static void main(String[] args) {
        ArrayStack ars = new ArrayStack();
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Postfix expression: ");
        String exp = scn.nextLine();

        for (char c : exp.toCharArray()) {
            if ((int)c > 47 && (int)c < 58)
                ars.push((int)c - 48);
            else if (c != ' ') {
                int b = ars.pop();
                int a = ars.pop();
                if (c == '+') ars.push(a+b);
                if (c == '-') ars.push(a-b);
                if (c == '*') ars.push(a*b);
                if (c == '/') ars.push(a/b);
            }
        }

        System.out.print("The result: " + ars.pop());
    }
}
