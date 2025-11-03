import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;



class Person{
    protected String name;
    public int id = 0;
    protected String location;
    protected ArrayList<TransportSystem> bookedTransports = new ArrayList<>();


    Person(int id, String name,  String location){
        this.id = id;
        this.name = name;
        this.location = location;
    }


    public void bookTransport(TransportSystem ts){
        if(ts.getVehicle() > 0){
            ts.reduceVehicle();
            bookedTransports.add(ts);
            System.out.println(name + " booked a " + ts.getClass().getSimpleName() + " to " + location + " at " + ts.getTime() );
            System.out.println("Fare: " + ts.getPrice());
        }else{
            System.out.println(" Sorry no" + ts.getClass().getSimpleName() + " available");
        }
    }


    public void showBookings(){
        System.out.println("Booking summary for: " + name);
        double totalfare = 0;

        for(TransportSystem t: bookedTransports){
            System.out.println('-' + t.getClass().getSimpleName() + " to " + location + "(" + t.getPrice() + "Frw)" );
            totalfare += t.getPrice();
        }

        System.out.println("Total Fare: " + totalfare + " Frw" );
    }


    public void saveBookings(){
        try(FileWriter  writer = new FileWriter(name + "_bookings.txt", true)){
            for(TransportSystem t : bookedTransports){
                writer.write(t.getClass().getSimpleName() + "," + location + "," + t.getPrice() + "," + t.getTime() + "\n");
            }

            System.out.println("Booking Saved Successfully!!!!");
        }catch(IOException e){
            System.out.println("Error saving Bookings: " + e.getMessage());
        }
    }


    public void loadBookings(){
        File file = new File(name + "_bookings.txt");
        if(!file.exists()){
            System.out.println("No previous bookings found.");
            return;
        }


        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;

            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                String type = parts[0];
                // String loc = parts[1];
                double price = Double.parseDouble(parts[2]);
                String time = parts[3];



                switch (type) {
                    case "Bus":
                        bookedTransports.add(new Bus(time,0,0, price));
                        break;
                    case "Car":
                        bookedTransports.add(new Car(time,0,0,price));
                        break;
                    case "Bike":
                        bookedTransports.add(new Bike(time,0,0, price));
                        break;
                }

            }
        }catch(IOException e){
            System.out.println("Error loading booking: " + e.getMessage());
        }
    }
}


abstract class TransportSystem {
    private double speed;
    private int capacity;
    private String time;
    private double price;


    abstract void start();
    abstract void stop();
    abstract void move();
    abstract int getVehicle();
    abstract void reduceVehicle();


    public TransportSystem( String time, double speed, int capacity , double price){
        this.time = time;
        this.speed = speed;
        this.capacity = capacity;
        this.price = price;
    }

    
    public double getSpeed(){return speed; }
    public int getCapacity(){return capacity; }
    public double getPrice(){return price; }
    public String getTime(){return time; }
    
}



class Bus extends TransportSystem{
    private static int vehicle = 3;

    Bus(String time, double speed, int capacity, double price){
            super(time, speed, capacity, price);
    }

    void start() { System.out.println("Bus starting with speed " + getSpeed()); }
    void move() { System.out.println("Bus is picking passengers."); }
    void stop() { System.out.println("Bus stopped."); }

    public int getVehicle(){ return vehicle;}
    public void reduceVehicle(){ vehicle--; }
}



class Car extends TransportSystem{
    private static int vehicle = 2;
    
    Car(String time, double speed, int capacity, double price){
            super(time, speed, capacity, price);
    }

    void start() { System.out.println("Car starting with speed " + getSpeed()); }
    void move() { System.out.println("Car driving on the road."); }
    void stop() { System.out.println("Car stopped."); }

    public int getVehicle(){ return vehicle;}
    public void reduceVehicle(){ vehicle--; }
}



class Bike extends TransportSystem{
    private static int vehicle = 1;

    Bike(String time, double speed, int capacity, double price) {
        super(time, speed, capacity, price);
    }
    void start() { System.out.println("Bike starting with speed " + getSpeed()); }
    void move() { System.out.println("Bike is pedaling."); }
    void stop() { System.out.println("Bike stopped."); }

    public int getVehicle(){ return vehicle;}
    public void reduceVehicle(){ vehicle--; }
}




public class Transport{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int userId = 1; 

        System.out.print("Enter your name: ");
        String username = sc.next();

        System.out.print("Enter destination: ");
        String location = sc.next();


        Person p = new Person(userId, username, location);
        p.loadBookings();

        boolean available = true;

        while(available) {
            System.out.println("Choose Tranport:   1. Bus   2. Car   3. Bike   4. Show Bookings   5. Exit");
            int choice;

            try{
                choice = sc.nextInt();

                if(choice == 5){
                    System.out.println("Good Bye!!");
                    break;
                }

                if(choice == 4){
                    p.showBookings();
                    continue;
                }

                System.out.print("Enter speed: ");
                double speed = sc.nextDouble();
                if(speed <= 0) throw new IllegalArgumentException("Speed must be positive");

                System.out.print("Enter capacity: ");
                int capacity = sc.nextInt();
                if(capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");

                System.out.print("Enter Price: ");
                double price = sc.nextDouble();
                if(price <= 0) throw new IllegalArgumentException("Price must be positive");

                System.out.print("Enter Time for departure (eg: 10:30 AM): ");
                sc.nextLine();
                String time = sc.nextLine();
                
                

                switch (choice) {
                    case 1:
                        p.bookTransport(new Bus(time, speed, capacity, price));
                        p.saveBookings();
                        break;
                    case 2:
                        p.bookTransport(new Car(time, speed, capacity, price));
                        p.saveBookings();
                        break;
                    case 3:
                        p.bookTransport(new Bike(time, speed, capacity, price));
                        p.saveBookings();
                        break;
                    default:
                        System.out.println("Invalid Choice !!");
                }

            }catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine();
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }

    
}