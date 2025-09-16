class Book {
    String title;
    String author;
    int year;


    Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }


    public String displayinfo(){
        return "Title: " + title + "Author: "  + author + "Year: " + year;
    }
}

class EBook extends Book{
    int fileSize;

    
    EBook(String title, String author, int year, int fileSize){
        super(title, author, year);

        this.fileSize = fileSize;
    }

    @Override
    public String displayinfo(){
        return super.displayinfo() + " Filesize: " + fileSize + "MB";
    }
}




abstract class BankAccount{

    double balance;

    BankAccount(double balance){
        this.balance = balance;
    }


    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    public double getBalance(){
         return balance;
    }

}


class SavingsAccount extends BankAccount{
    private double interestRate = 0.05;

    SavingsAccount(double balance){
        super(balance);
    }

    @Override
    public void deposit(double amount){
        balance += amount + (amount * interestRate);
        System.out.println("Deposited with interest. New balance: " + balance);
    }

    @Override
    public void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("Withdrwa from savings. New balance: " + balance);
        }else{
            System.out.println("insufucient savings!! " );
        }
    }
}



// CheckingAccount subclass
class CheckingAccount extends BankAccount {
    private double fee = 1.0; // flat fee for each withdrawal

    CheckingAccount(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited into Checking. New balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount + fee <= balance) {
            balance -= (amount + fee);
            System.out.println("Withdrawn from Checking (with fee). New balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Checking!");
        }
    }
}



public class Exercises {
    public static void main(String[] args){
        // Book books = new Book("Java Intermediate", "Sandrine", 2025);
        // System.out.println(books.displayinfo());

        // EBook books2 = new EBook("Java Intermediate", "Sandrine", 2025, 35);
        // System.out.println(books2.displayinfo());


        Book[] book = new Book[2];

        book[0] = new Book("Java Intermediate", "Sandrine", 2025);
        book[1] = new EBook("Java Intermediate", "Sandrine", 2025, 35);

        for(int i = 0; i < book.length; i++){
            System.out.println(book[i].displayinfo());
        }



        BankAccount savings = new SavingsAccount(1000);
        BankAccount checking = new CheckingAccount(5000);

        savings.deposit(10000);
        savings.withdraw(2000);


        checking.deposit(20000);
        checking.withdraw(3000);
    }
}