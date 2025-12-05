

abstract class User{
    private String name;
    private String email;

    User(String name, String email){
        this.name = name;
        this.email = email;
    }

    String getName(){
        return name;
    }

    void setName(String name){
        this.name = name;
    }

     String getEmail(){
        return email;
    }

    void setEmail(String email){
        this.email = email;
    }

    abstract void displayinfo();
}


class Admin extends User{
    String role;

    Admin(String name, String email, String role){
        super(name, email);
        this.role = role;
    }

    void manageProducts(){

    }

    @Override
    void displayinfo(){

    }

}


class Customer extends User{
    String cart;
    double amount;

    Customer(String name, String email, String cart, double amount){
        super(name, email);
        this.cart = cart;
        this.amount = amount;
    }

    @Override
    void displayinfo(){

    }


    void checkout(PaymentMethod g){
        g.pay(amount);
    }
}


interface PaymentMethod{
    void pay(double amount);
}


class Paypal implements PaymentMethod{
    double amount;

    public void pay(double amount){
        System.out.println("I am paying using Paypal");
    }
}

class Momo implements PaymentMethod{

    public void pay(double amount){
        System.out.println("I am paying using Paypal");
    }
}

public class OOPCAT{
    public static void main(String[] args) {
        
    }
}