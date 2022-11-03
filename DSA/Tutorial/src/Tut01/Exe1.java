package Tut01;

import java.util.Scanner;

public class Exe1 {
    public static void main(String[] args) {
        System.out.print("Enter a name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        name = name.replaceAll(" ", "");
        System.out.println("The numbers of characters: " + name.length());
        scanner.close();
    }
}
