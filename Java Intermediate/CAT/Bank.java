import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}


abstract class Account implements Serializable{
    int AccountNumber;
    String holderName;
    double balance;


    Account(int AccountNumber, String holderName, double balance){
        this.AccountNumber = AccountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }


    abstract void deposit(double amount);
    abstract void withdraw(double amount) throws InsufficientFundsException;
    void displaybalance(){
        System.out.println(holderName + " has balance: " + balance);
    }
}


interface InterestBearing {
    double calculateInterest();
}


class SavingAccount extends Account implements InterestBearing{
    double rate;

    SavingAccount(int AccountNumber, String holderName, double balance, double rate){
        super(AccountNumber, holderName, balance);
        this.rate = rate;
    }

    @Override
    void deposit(double amount){
        balance += amount + (amount * rate);
    }

    @Override
    void withdraw(double amount) throws InsufficientFundsException{
        if(balance - amount < 0){
            throw new InsufficientFundsException("Insufficient funds !!!!!");
        }else{
            balance -= amount;
        }
    }

    @Override
    public double calculateInterest(){
        return balance * rate;
    }
}


class CurrentAccount extends Account{
    double overdraft = 5000;

    CurrentAccount(int AccountNumber, String holderName, double balance, double overdraft ){
        super(AccountNumber, holderName, balance);
        this.overdraft = overdraft;
    }


    void withdraw(double amount) throws InsufficientFundsException{
        if(amount > balance + overdraft){
            throw new InsufficientFundsException("Insuffiecient Funds !!!");
        }else{
            balance -= amount ;
        }
    }

    void deposit(double amount){
        balance += amount;
    }
}


class Banking implements Serializable {
    private List<Account> accounts = new ArrayList<>();
   
    void addAccount(Account acc){ accounts.add(acc);}
    void showAllAccounts(){
        for(Account ac : accounts){
            ac.displaybalance();    
        }
    }

    List<Account> geAccounts() { return accounts; }
}


public class Bank{
    public static void main(String[] args) throws IOException {
       
        Banking kigali = new Banking();

        kigali.addAccount(new SavingAccount(101, "Alice", 1000000, 0.04 ));
        kigali.addAccount(new CurrentAccount(102, "John", 3000000, 10000 ));
        kigali.addAccount(new SavingAccount(103, "Doe", 4000000, 0.05 ));


        for(Account acc: kigali.geAccounts()){
            try{
                acc.deposit(500000);
                acc.withdraw(200000);
            }catch(InsufficientFundsException e){
                e.getMessage();
            }
        }


        System.out.println("\nFinal Balances: \n");
        kigali.showAllAccounts();

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("accounts.ser"))){
            out.writeObject(kigali);
        }catch(IOException e){
            e.getMessage();
        }



        Banking loaadedBank = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("accounts.ser"))){
            loaadedBank = (Banking) in.readObject();
            System.out.println("Accounts Successfully loaded from accounts.ser\n");
        }catch (Exception e) {
            e.printStackTrace();
        }


        if(loaadedBank != null){
            System.out.println("Balance after loading: \n");
            loaadedBank.showAllAccounts();
        }
    }
}