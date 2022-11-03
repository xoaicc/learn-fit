import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO: your code here
        Scanner inp = new Scanner(System.in);
        BookManager sys = new BookManager();
        int choice = -1, id;
        String name;
        double price;
        Book bok;

        sys.loadFromFile();

        while (choice != 0) {
            System.out.print("-----------------------------------\n1. list all books\n2. add a new book\n3. edit book\n4. delete a book\n5. search books by name\n6. sort books descending by price\n\n0. save & exit\n-----------------------------------\nYour option: ");
            choice = inp.nextInt();
            inp.nextLine();
            switch (choice) {
                case 0:
                    sys.saveToFile();
                    System.out.println("Bye!");
                    break;
                case 1:
                    if (sys.getBooks().isEmpty()) System.out.println("(empty)");
                    else sys.printBooks(sys.getBooks());
                    break;
                case 2:
                    System.out.print("Enter book id: ");
                    id = inp.nextInt();
                    inp.nextLine();
                    System.out.print("Enter book name: ");
                    name = inp.nextLine();
                    System.out.print("Enter book price: ");
                    price = inp.nextDouble();
                    bok = new Book(id, name, price);
                    if(sys.add(bok) == true) System.out.println("Added successfully.");
                    else System.out.println("Duplicated ID!");
                    break;
                case 3:
                    System.out.print("Enter book id: ");
                    id = inp.nextInt();
                    inp.nextLine();
                    if (sys.getBookById(id) == null) {
                        System.out.println("Invalid ID!");
                        break;
                    } else bok = sys.getBookById(id);
                    System.out.print("Enter book name: ");
                    name = inp.nextLine();
                    System.out.print("Enter book price: ");
                    price = inp.nextDouble();
                    bok.setName(name);
                    bok.setPrice(price);
                    System.out.println("Updated successfully.");
                    break;
                case 4:
                    System.out.print("Enter book id: ");
                    id = inp.nextInt();
                    inp.nextLine();
                    if (sys.getBookById(id) == null) {
                        System.out.println("Invalid ID!");
                        break;
                    }
                    sys.remove(sys.getBookById(id));
                    System.out.println("Deleted successfully.");
                    break;
                case 5:
                    System.out.print("Enter keyword: ");
                    String key = inp.nextLine();
                    if (sys.searchByName(key).isEmpty()) System.out.println("(empty)");
                    else sys.printBooks(sys.searchByName(key));
                    break;
                case 6:
                    if (sys.getBooks().isEmpty()) System.out.println("(empty)");
                    else {
                        System.out.println("After sorting:");
                        sys.sortDescByPrice();
                        sys.printBooks(sys.getBooks());
                    }
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
        inp.close();
    }
}