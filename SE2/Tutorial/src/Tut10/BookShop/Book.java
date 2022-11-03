package Tut10.BookShop;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }

    protected String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        if (title.length() < 3) throw new IllegalArgumentException("Title not valid!");
        this.title = title;
    }

    protected String getAuthor() {
        return author;
    }

    protected void setAuthor(String author) {
        String[] names = author.split(" ");
        if (names.length != 2 || ((int)names[1].charAt(0) > 47 && (int)names[1].charAt(0) < 58))
            throw new IllegalArgumentException("Author not valid!");
        this.author = author;
    }

    protected double getPrice() {
        return price;
    }

    protected void setPrice(double price) throws IllegalArgumentException {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }
}
