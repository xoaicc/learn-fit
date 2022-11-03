package PR1Tutorial.Tut08;

import java.util.ArrayList;
import java.util.Scanner;

public class Act3 {
    static ArrayList<String> arrList = new ArrayList<String>();
    public static ArrayList<String> removeEvenLength(ArrayList<String> arrList) {
        for (String s : arrList) {
            if (s.length() % 2 == 0) arrList.remove(s);
        }
        return arrList;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of string to input: ");
        int num = input.nextInt();
        input.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.print("Enter string " + (i+1) + ": ");
            arrList.add(input.nextLine());
        }
        System.out.print("All of string without even length: ");
        for (String s : removeEvenLength(arrList)) {
            System.out.print(s + ", ");
        }
    }
}