package SE1Tutorial.Tut08.StockTrader.Client;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import SE1Tutorial.Tut08.StockTrader.Server.StockServer;

public class StockClient {
    private static final List<String> SUPPORTED_OPS = Arrays.asList(
            "1", "2", "3", "4", "5", "X"
    );
    private final StockServer controller = new StockServer();
    private final Scanner scanner = new Scanner(System.in);

    private void showMenu(boolean hasLogin) {
        if (!hasLogin) {
            System.out.println("Please log in to continue");
        } else {
            System.out.println("Choose an option to continue");
            System.out.println("[1] List all stocks");
            System.out.println("[2] Purchase stock");
            System.out.println("[3] List your own stocks");
            System.out.println("[4] Sell stocks");
            System.out.println("[5] Track stocks");
            System.out.println("[X] Exit");
            System.out.print("Your choice: ");
        }
    }

    private String getUserOption() {
        String userOption;
        while (true) {
            userOption = scanner.nextLine();
            if (SUPPORTED_OPS.contains(userOption)) {
                break;
            }
        }
        return userOption;
    }

    private String getUserInput(String promptMessage) {
        System.out.print(promptMessage + " ");
        return scanner.nextLine();
    }

    private int getUserIntInput(String promptMessage) {
        while (true) {
            try {
                System.out.print(promptMessage + " ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Invalid number filled, please try again!");
            }
        }
    }

    private boolean doLogin() {
        String username = getUserInput("Username:");
        String password = getUserInput("Password:");
        String result = controller.login(username, password);
        if (result.equals("OK")) {
            System.out.println("Successfully logged in.");
            return true;
        } else {
            System.err.println("Login failed, please try again!");
            return false;
        }
    }

    private void doOption(String option) {
        switch (option) {
            case "1": {
                // call ListAllStocks
                System.out.println("---- ALL STOCKS ----");
                String output = controller.listAllStocks();
                System.out.println(output);
                break;
            }
            case "2": {
                // gather user input for stock no & quantity
                System.out.println("---- Purchase stock ----");
                int stockNo = getUserIntInput("Stock no:");
                int quantity = getUserIntInput("Quantity:");
                boolean succeeded = controller.purchase(stockNo, quantity);
                if (succeeded) {
                    System.out.println("Successfully purchased!");
                } else {
                    System.err.println("Transaction failed, please try again!");
                }
                break;
            }
            case "3": {
                // call ListOwnStocks
                System.out.println("---- YOUR STOCKS ----");
                String output = controller.listOwnStocks();
                System.out.println(output);
                break;
            }
            case "4": {
                // get user input & call sellStock
                System.out.println("---- Sell stock ----");
                int stockNo = getUserIntInput("Stock no:");
                int quantity = getUserIntInput("Quantity:");
                boolean succeeded = controller.sellStock(stockNo, quantity);
                if (succeeded) {
                    System.out.println("Successfully sold!");
                } else {
                    System.err.println("Transaction failed, please try again!");
                }
                break;
            }
            case "5": {
                // call TrackStocks
                System.out.println("---- DAILY STOCKS STATS ----");
                String output = controller.trackStocks();
                System.out.println(output);
                break;
            }
            case "X": {
                System.out.println("Bye bye!");
                System.exit(0);
            }
        }
        System.out.println("----------");
    }

    public static void main(String[] args) {
        StockClient client = new StockClient();
        boolean hasLogin = false;
        // Prompt user to login until successfully logged in
        client.showMenu(hasLogin);
        while (!hasLogin) {
            hasLogin = client.doLogin();
        }
        while (true) {
            client.showMenu(hasLogin);
            String option = client.getUserOption();
            client.doOption(option);
        }
    }
}
