class Book {
    private String title;
    private String author;
    private boolean isAvailable = true;


    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

 
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}


class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}


class Student extends Person {
    private String department;

    public Student(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }

    public void borrowBook(Book b) {
        if (b.isAvailable()) {
            b.setAvailable(false);
            System.out.println(name + " borrowed " + b.getTitle() + "studies in " + department);
        } else {
            System.out.println(b.getTitle() + " is not available.");
        }
    }
}



class Staff extends Person {
    public Staff(String name, int id) {
        super(name, id);
    }

    public void manageBook(Book b, boolean add) {
        if (add) {
            System.out.println(name + " added " + b.getTitle());
        } else {
            System.out.println(name + " removed " + b.getTitle());
        }
    } 
}



abstract class LibraryUser {
    protected String name;
    public LibraryUser(String name) { this.name = name; }
    public abstract void accessLibrary();
}


class StudentUser extends LibraryUser {
    public StudentUser(String name) { super(name); }
    public void accessLibrary() {
        System.out.println(name + " borrows books.");
    }
}


class StaffUser extends LibraryUser {
    public StaffUser(String name) { super(name); }
    public void accessLibrary() {
        System.out.println(name + " manages library.");
    }
}


public class LibraryDemo {
    public static void main(String[] args) {
        // Books
        Book b1 = new Book("Java Basics", "James Gosling");
        Book b2 = new Book("OOP Concepts", "Bjarne Stroustrup");

        // Student & Staff
        Student s = new Student("Alice", 1, "CS");
        Staff st = new Staff("Bob", 2);

        // Borrow book
        s.borrowBook(b1);
        s.borrowBook(b1); 

        // Return book
        b1.setAvailable(true);
        System.out.println("Book returned: " + b1.getTitle());

        // Staff manages books
        st.manageBook(b2, true);
        st.manageBook(b1, false);

        // Abstraction 
        LibraryUser u1 = new StudentUser("Alice");
        LibraryUser u2 = new StaffUser("Bob");
        u1.accessLibrary();
        u2.accessLibrary();
    }
}
