package Tut07.a;

import java.util.Scanner;

public class GreetingConversation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many people to input: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter info of id " + i);

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter manufacturer name: ");
            String mName = scanner.nextLine();

            System.out.print("Enter model: ");
            String model = scanner.nextLine();

            System.out.print("Enter color (R/O/Y/P): ");
            char color = scanner.nextLine().charAt(0);

            System.out.print("Enter year (20xx): ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter guaranteed (true/false): ");
            boolean guar = scanner.nextBoolean();
            scanner.nextLine();

            MobilePhone mp = new MobilePhone(mName, model, color, year, guar);
            Person ps = new Person(i, name, mp);

            if (i == 1) System.out.println(ps.greet());
            System.out.println("-------------");
        }
        scanner.close();
    }
}
