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


public class ReadBooks {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.ser"))) {
            @SuppressWarnings("unchecked")
            List<Book> books = (List<Book>) ois.readObject();


            for(Book bk: books){
                System.out.println(bk);
            }

            books.forEach(System.out::println);
        }
    }
}

