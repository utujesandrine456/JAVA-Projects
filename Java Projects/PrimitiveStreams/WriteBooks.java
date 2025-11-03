import java.io.*;
import java.util.*;

class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private double price;

    public Book(String t, String a, double p) { title=t; author=a; price=p; }
    public String toString(){ return title + " by " + author + " $" + price; }
}


public class WriteBooks implements Serializable {
    public static void main(String[] args) throws IOException {
        List<Book> books = Arrays.asList(
            new Book("Java Basics","A. Author",29.99),
            new Book("Data Structures","B. Writer",39.50)
        );

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.ser"))) {
            oos.writeObject(books);
        }
    }
}
