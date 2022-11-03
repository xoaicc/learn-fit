import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class BookManager {
    // TODO: your code here
    // attribute books
    ArrayList<Book> books;

    public BookManager() {
        // TODO: your code here
        books = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks() {
        // TODO: your code here
        return books;
    }

    /**
     * update this.books by reading books from file books.txt
     */
    public void loadFromFile() {
        // TODO: your code here
        System.out.println("Loading books...");
        try {
            File file = new File("books.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                int id = Integer.parseInt(data.substring(0,5).trim());
                String name = data.substring(6,50).trim();
                double price = Double.parseDouble(data.substring(51).trim());
                books.add(new Book(id, name, price));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not exist!");
        }
    }

    /**
     * print books (one/line) in required format
     */
    public void printBooks(ArrayList<Book> books) {
        // TODO: your code here
        System.out.printf("%-5s %-45s %-10s\n", "ID", "Name", "Price");
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    /**
     * if book.id is not duplicated, add book to this.books
     * return whether added or not
     */
    public boolean add(Book book) {
        // TODO: your code here
        for (Book bok : books) if (bok.id == book.id) return false;
        books.add(book);
        return true;
    }

    /**
     * return book specified by id, null if not found
     */
    public Book getBookById(int id) {
        // TODO: your code here
        for (Book book : books) {
            if (book.id == id) return book;
        }
        return null;
    }

    /**
     * remove book from this.books
     */
    public void remove(Book book) {
        // TODO: your code here
        books.remove(book);
    }

    /**
     * update this.books to be sorted by price from high -> low
     */
    public void sortDescByPrice() {
        // TODO: your code here
        ArrayList<Double> sort = new ArrayList<Double>();
        ArrayList<Book> boks = new ArrayList<Book>();
        for (Book book : books) {
            if (!sort.contains(book.price)) sort.add(book.price);
        }
        Collections.sort(sort, Collections.reverseOrder());
        for (Double s : sort) {
            for (Book book : books) {
                if (book.price == s) boks.add(book);
            }
        }
        books = boks;
    }

    /**
     * return all books having name contains keyword (case in-sensitive)
     */
    public ArrayList<Book> searchByName(String keyword) {
        // TODO: your code here
        ArrayList<Book> matches = new ArrayList<>();
        for (Book book : books) {
            if (book.name.toLowerCase().contains(keyword.toLowerCase())) matches.add(book);
        }
        return matches;
    }

    /**
     * write this.books to file books.txt in required format
     */
    public void saveToFile() {
        // TODO: your code here
        System.out.println("Saving to file...");
        try {
            PrintWriter outFile = new PrintWriter("books.txt");
            for (Book book : books) outFile.println(book.toString());
            outFile.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
