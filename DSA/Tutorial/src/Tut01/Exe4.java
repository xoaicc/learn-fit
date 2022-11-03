package Tut01;

import java.util.Scanner;

public class Exe4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount of list: ");
        int N = scanner.nextInt();
        scanner.nextLine();

        String[] names = new String[N];

        for (int i = 0; i < N; i++) {
            System.out.print("Enter the name " + (i+1) + ": ");
            names[i] = scanner.nextLine();
        }

        System.out.print("Enter the name to search: ");
        String sName = scanner.nextLine();
        scanner.close();

        System.out.print("The result: " );
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (names[i].contains(sName)) {
                System.out.println(names[i]);
                count++;
            }
        }
        if (count == 0) System.out.println("-1");
    }
}
