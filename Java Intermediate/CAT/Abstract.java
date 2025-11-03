
abstract class PaymentGateway{
    String name;
    double amount;

    PaymentGateway(String name, double amount){
        this.name = name;
        this.amount = amount;
    }

    abstract void payment();

    void method(){
        System.out.println("Hello world");
    }
}

interface InnerAbstract {
    abstract void hello();
    void hello2();
}

class PaymentProcessor{
    public PaymentGateway payment;

    public PaymentProcessor(PaymentGateway pay){
        this.payment = pay;
    }

    public void paymentprocess(){
        payment.payment();
    }
}


class Paypal extends PaymentGateway{
    Paypal(String name,double amount){
        super(name, amount);
    }
    

    void payment(){
        System.out.println("Name: " + name + " is paying " + amount + " using Paypal");
    }
}


class MasterCard extends PaymentGateway{
    MasterCard(String name,double amount){
        super(name, amount);
    }

    void payment(){
        System.out.println("Name: " + name + " is paying " + amount + " using MasterCard");
    }
}


class Momo extends PaymentGateway{
    Momo(String name,double amount){
        super(name, amount);
    }

    void payment(){
        System.out.println("Name: " + name +  " is paying " + amount + " using Momo");
    }
}




public class Abstract {
    public static void main(String[] args) {
        PaymentGateway pg1 = new Paypal("Sandrine", 1200000);
        PaymentGateway pg2 = new MasterCard("UWASE", 2300000);
        PaymentGateway pg3 = new Momo("UTUJE", 3700000);


        PaymentProcessor proc = new PaymentProcessor(pg1);
        PaymentProcessor proc2 = new PaymentProcessor(pg2);
        PaymentProcessor proc3 = new PaymentProcessor(pg3);


        proc.payment.payment();
        proc2.paymentprocess();
        proc3.payment.payment();
    }
}
