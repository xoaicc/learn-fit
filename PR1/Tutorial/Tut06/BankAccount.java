package PR1Tutorial.Tut06;

import java.util.Scanner;

public class BankAccount {
    double balance;
    int transactions;
    String name;

    public BankAccount(double initial, String name) {
        this.balance = initial;
        this.transactions = 1;
        this.name = name;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions++;
    }

    public void withdraw(double amount) {
        balance -= amount;
        transactions++;
    }

    public void monthlyFee() {
        this.withdraw(10);
    }

    public void yearlyInterst() {
        deposit(balance * 0.006 * 12);
    }

    public void transfer(double amount) {
        if (balance >= (amount + 0.5)) {
            this.withdraw(amount + 0.5);
            transactions++;
            System.out.println("Transfer succesfully!");
        }
        else System.out.println("Sorry! Your account is not enought money to transer.");
    }

    public String toString() {
        return ("Account info: \n" + name + ", " + balance);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter the balance in your account: ");
        int money = input.nextInt();
        BankAccount myAccount = new BankAccount(money, name);
        while (true) {
            System.out.println("Done! Choose what you want:\n1. Deposit money\n2. Withdraw money\n3. Transfer money\n4. Watch account information");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount of money to deposit: ");
                    int amount1 = input.nextInt();
                    myAccount.deposit(amount1);
                    System.out.println("Deposit succesfully!");
                    break;
                case 2:
                    System.out.print("Enter the amount of money to withdraw: ");
                    int amount2 = input.nextInt();
                    myAccount.withdraw(amount2);
                    System.out.println("Withdraw succesfully!");
                    break;
                case 3:
                    System.out.print("Enter the amount of money to transfer: ");
                    int amount3 = input.nextInt();
                    myAccount.transfer(amount3);
                    break;
                case 4:
                    System.out.println(myAccount.toString());
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