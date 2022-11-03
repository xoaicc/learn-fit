//package Tut08;
//
//import java.util.Scanner;
//
//public class Exe2 {
//    public static void main(String[] args) {
//        ArrayStack ars = new ArrayStack();
//        Scanner scn = new Scanner(System.in);
//        System.out.print("Enter Infix expression: ");
//        String exp = scn.nextLine();
//
//        System.out.print("The Postfix: ");
//        for (char c : exp.toCharArray()) {
//            if ((int)c > 47 && (int)c < 58)
//                System.out.print((int)c - 48);
//            else if (c != ' ') {
//                ars.push(c);
//            }
//        }
//    }
//}
