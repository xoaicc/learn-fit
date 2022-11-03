package Tut06.SLList;

import java.util.Scanner;

public class Polynomial {
    public static void printPolynomial(SLList list)
    {
        int l = list.getLength();
        String str="";

        for (int i = l; i >= 1; i-=2)
        {
            SLNode deg = list.get(i-1);
            SLNode coe = deg.getNext();
            String c = coe.getData();
            String d = deg.getData();

            if (d.equals("0")) str += c;
            else if (d.equals("1")) str += c + "x + ";
            else str += c + "x^" + d + " + ";
        }

        System.out.println(str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLList myList = new SLList();

        System.out.println("Enter operators of your polynomial (left to right; \".\" to end)");

        while (true) {
            String op = scanner.next();
            if (op.equals(".")) break;
            myList.add(new SLNode(op));
        }

        printPolynomial(myList);
    }
}
