import java.util.Scanner;

class Person {
    int id;
    String name;
    String dob;

    Person(int id, String name, String dob){
        this.id = id;
        this.name = name;
        this.dob = dob;
    }
}


class Account extends Person{
    int accountnumber;
    private double balance = 0;
    double amount;

    Account(int id, String name, String dob, int accountnumber){
        super(id, name, dob);
        this.accountnumber = accountnumber;
        
    }

   
    double getBalance(){
        return balance;
    }
    
    
    void deposit(double amount){
        if(amount < 0){
            System.out.println("Enter positive money");
        }
        balance += amount;
        System.out.println("You sucessfully have deposited " + amount);
    }

    void withdraw(double amount){
        if( amount > balance){
            System.out.println("Your balance is low !!!");
        }else{
            balance -= amount;
            System.out.println("You sucessfully have withdrawn " + amount);
        }
    }
}



public class Bank {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        

        System.out.println("Enter your id:");
        int id = sc.nextInt();

        System.out.println("Enter your name:");
        String username = sc.next();

        System.out.println("Enter your Date of Birth :");
        String date = sc.next();

        System.out.println("Enter your Account number");
        int number = sc.nextInt();

        Account kigali = new Account(id, username, date, number);


        boolean available = true;
        do{
            System.out.println("1. Deposit 2. Withdraw 3. Exit");
            int choice = sc.nextInt();

            if(choice == 1){
                System.out.print("Enter the amount to deposit number: ");
                int deposit = sc.nextInt();

                kigali.deposit(deposit);
                System.out.println("Your new Balance is: " + kigali.getBalance());
            }else if(choice == 2){
                System.out.print("Enter the amount to withdraw number: ");
                int withdraw = sc.nextInt();

                kigali.withdraw(withdraw);
                System.out.println("Your new balance is: " + kigali.getBalance());
            }else if(choice == 3){
                available = false;
                
            }else{
                System.out.println("Enter a valid number among the choices");
                sc.close();
                return ;
            }
        }while(available);
        
        sc.close();
    }
}

