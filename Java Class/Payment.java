abstract class PaymentGateway{
    String name;
    int amount;
    String location;

    PaymentGateway(String name, int amount, String location){
        this.name = name;
        this.amount = amount;
        this.location = location;

    }

    abstract void payment();
}


class Paymentprocessor{
    public PaymentGateway payment;

    public Paymentprocessor(PaymentGateway p){
        this.payment = p;
    }

    public void paymentprocess(){
        payment.payment();
    }
}


class MasterCard extends PaymentGateway{

    MasterCard(String name, int amount, String location){
        super(name, amount, location);
    }

    @Override
    void payment(){
        System.out.println("Paying " + amount + " using MasterCard at " + location);
    }

}


class Paypal extends PaymentGateway{

    Paypal(String name, int amount, String location){
        super(name, amount, location);
    }

    @Override
    void payment(){
        System.out.println("Paying " + amount + " using Paypal at " + location);
    }
}




public class Payment {
    public static void main(String[] args){
        PaymentGateway pg1 = new MasterCard("MasterCard", 500, "Kigali");
        PaymentGateway pg2 = new Paypal("PayPal", 300, "NY");

        Paymentprocessor processor1 = new Paymentprocessor(pg1);
        Paymentprocessor processor2 = new Paymentprocessor(pg2);

        processor1.payment.payment();
        processor2.payment.payment();
        processor1.paymentprocess();
        processor2.paymentprocess();
    }
}
