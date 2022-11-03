package PR1Tutorial.Tut10;

import java.util.Scanner;

class Act1 {
    public static void main(String[] args) {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        while (choice != 5) {
            System.out.print("[1] Add item\n[2] Item list\n[3] Edit an item\n[4] Remove an item\n[5] Quit\nChoose an option: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                System.out.println("\nAdding a new item...\n");
                break;
                case 2:
                System.out.println("\nListing all items...\n");
                break;
                case 3:
                System.out.println("\nEditing a new item...\n");
                break;
                case 4:
                System.out.println("\nRemoving a new item...\n");
                break;
                case 5:
                System.out.println("\nGoodbye!");
                break;
                default:
                System.out.println("\nInvalid choice!\n");
                break;
            }
        }
        input.close();
    }
}