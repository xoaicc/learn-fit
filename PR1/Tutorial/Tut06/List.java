package PR1Tutorial.Tut06;

import java.util.Scanner;

public class List {
    int size = 0;
    int[] els = new int[size];

    public void add(int num) {
        int[] els2 = new int[size + 1];
        for (int i = 0; i < size; i++) els2[i] = els[i];
        els2[size] = num;
        size += 1;
        int[] els = new int[size];
        for (int i = 0; i < size; i++) els[i] = els2[i];
    }

    public void remove(int index) {
        int[] els2 = new int[size - 1];
        for (int i = 0; i < index; i++) els2[i] = els[i];
        size -= 1;
        for (int i = index + 1; i < size; i++) els2[i - 1] = els[i];
        int[] els = new int[size];
        for (int i = 0; i < size; i++) els[i] = els2[i];
    }
    
    public int get(int index) {
        if (size == 0) return -999999999;
        else return els[index];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List func = new List();
        while (true) {
            System.out.println("Choose what you want:\n1. Add a value\n2. Remove a value\n3. Get a value");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter a num to add: ");
                    int num1 = input.nextInt();
                    func.add(num1);
                    System.out.println("Add succesfully!");
                    break;
                case 2:
                    System.out.print("Enter an index to remove: ");
                    int num2 = input.nextInt();
                    func.remove(num2);
                    System.out.println("Remove succesfully!");
                    break;
                case 3:
                    System.out.print("Enter an index to show: ");
                    int num3 = input.nextInt();
                    System.out.println(func.get(num3));
                    break;
                default:
                    break;
            }
            input.nextLine(); // Just for fixing
            System.out.print("Do you want to exit (y/n)?\n=> ");
            if (input.nextLine().equals("y")) break;
        }
    }
}