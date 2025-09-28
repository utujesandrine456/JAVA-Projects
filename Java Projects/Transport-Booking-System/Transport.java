import java.util.Scanner;

abstract class TransportSystem{
    private double speed;
    private int capacity;

    abstract void start();
    abstract void stop();
    abstract void move();


    TransportSystem(double speed, int capacity){
        this.speed = speed;
        this.capacity = capacity;
    }

    double getSpeed(){
        return speed;
    }

    int getCapacity(){
        return capacity;
    }

    void setter(double speed, int capacity){
        this.speed = speed;
        this.capacity = capacity;
    }
}



class Bus extends TransportSystem{

    Bus(double speed, int capacity){
        super(speed, capacity);
    }

    void start(){
        System.out.println("Bus is going to start to move" + "and moves with speed of " + getSpeed() + " and  has a capacity of " +  getCapacity());
    }

    void move(){
        System.out.println("Bus is picking up passengers");
    }

    void stop(){
        System.out.println("Bus has stopped.");
    }

}



class Car extends TransportSystem{

    Car(double speed, int capacity){
        super(speed, capacity);
    }

    void start(){
        System.out.println("Car is going to start to move" + "and moves with speed of " + getSpeed() + " and  has a capacity of " +  getCapacity());
    }

    void move(){
        System.out.println("Car is driving on the road ");
    }

    void stop(){
        System.out.println("Car has stopped.");
    }

}



class Bike extends TransportSystem{

    Bike(double speed, int capacity){
        super(speed, capacity);
    }

    void start(){
        System.out.println("Bike is going to start to move" + "and moves with speed of " + getSpeed() + " and  has a capacity of " +  getCapacity());
    }

    void move(){
        System.out.println("Bike is pedaling ");
    }

    void stop(){
        System.out.println("Bike has stopped.");
    }

}


class Person{
    String name;

    Person(String name){
        this.name = name;
    }

    void bookTransport(TransportSystem ts){
        System.out.println(name + "  booked a transport");
        ts.start();
        ts.move();
        ts.stop();  
    }
}




public class Transport{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String username = sc.nextLine();
        Person p = new Person(username);

        System.out.println("Choose tranport: 1. Bus   2. Car   3. Bike");
        int choice = sc.nextInt();

        System.out.print("Enter speed: ");
        double speed = sc.nextDouble();

        System.out.print("Enter capacity: ");
        int capacity = sc.nextInt();


        if(choice == 1){
            p.bookTransport(new Bus(speed, capacity));
        } else if(choice == 2){
            p.bookTransport(new Car(speed, capacity));
        } else if(choice == 3){
            p.bookTransport(new Bike(speed, capacity));
        } else{
            System.out.println("This Transport method does not exist !!!");
        }
    }
}