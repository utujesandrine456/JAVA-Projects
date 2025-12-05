// import java.util.Scanner;

class Animal{
    void sound(){
        System.out.println("Animal sound");
    }
}

class Dog extends Animal{
    @Override
    void sound(){
        System.out.println("Bark");
    }
}

interface AnimalInterface{
    void sound();
}

class DogInterface implements AnimalInterface{
    @Override
    public void sound(){
        System.out.println("Bark from interface");
    }
}


interface Say {
    void speak(String message);
}

interface PaymentGateway{
    void pay(double amount);

    default void printReceipt(){
        System.out.println("Receipt printed");
    }


    static void showGatewayRules(){
        System.out.println("All payments must be secure");
    }
}


class Paypal implements PaymentGateway{
    @Override
    public void pay(double amount){
        System.out.println("Paid " + amount + " using PayPal");
    }
}


public class Basics {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter your name: ");
        // String name = scanner.nextLine();
        // System.out.println("Hello, " + name + "!");
        // scanner.close();


        // switch (name) {
        //     case "Sandrine":
        //         System.out.println();
        //         break;
        
        //     default:
        //         break;
        // }


        Animal dog = new Dog();
        dog.sound();

        Dog dog2 =(Dog) dog;
        dog2.sound();


        Say s = (msg) -> System.out.println("Hello " + msg);
        s.speak("Sandrine");

        PaymentGateway paypal = new Paypal();
        paypal.pay(20000);
        paypal.printReceipt();
        PaymentGateway.showGatewayRules();
    }    
}
