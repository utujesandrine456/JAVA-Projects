import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BookingSystem {

    private static final Pattern TIME_PATTERN = Pattern.compile("^(0?[1-9]|1[0-2]):[0-5][0-9]\\s?(AM|PM|am|pm)$");

    enum VehicleType { BUS, CAR, BIKE }

    private static final HashMap<VehicleType, Integer> vehicles = new HashMap<VehicleType, Integer>();

    static {
        vehicles.put(VehicleType.BUS, 2);
        vehicles.put(VehicleType.CAR, 3);
        vehicles.put(VehicleType.BIKE, 5);
    }

    public static synchronized void waitForVehicle(VehicleType type) {
        while (vehicles.get(type) == 0) {
            try {
                System.out.println("No " + type + " available. Waiting...");
                BookingSystem.class.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static synchronized void useVehicle(VehicleType type) {
        vehicles.put(type, vehicles.get(type) - 1);
    }

    public static synchronized void addVehicle(VehicleType type, int count) {
        vehicles.put(type, vehicles.get(type) + count);
        System.out.println("Added " + count + " " + type + "(s)");
        BookingSystem.class.notifyAll();
    }

    public static void displayAvailable() {
        System.out.println("\nAvailable Vehicles:");
        for (Map.Entry<VehicleType, Integer> entry : vehicles.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }

    static class Booking {
        private final String name;

        public Booking(String name) {
            this.name = name;
        }

        public void bookRide(final String from, final String to, final VehicleType type, final double fare, final String time) {
            Thread bookingThread = new Thread(new Runnable() {
                public void run() {
                    waitForVehicle(type);
                    useVehicle(type);
                    saveBooking(from, to, type, fare, time);
                    System.out.println("Booking completed for " + name + " using " + type);
                }
            });

            bookingThread.start();

            try {
                bookingThread.join();
            } catch (InterruptedException ignored) {}
        }

        private void saveBooking(String from, String to, VehicleType type, double fare, String time) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(name + "_bookings.txt", true));

                writer.write(from + "|" + to + "|" + type + "|" + fare + "|" + time);
                writer.newLine();
                writer.close();

            } catch (IOException e) {
                System.out.println("Error saving booking: " + e.getMessage());
            }
        }

        public void showBookings() {
            System.out.println("\nBookings for " + name);

            try {
                BufferedReader reader = new BufferedReader(new FileReader(name + "_bookings.txt"));

                String line;
                boolean empty = true;
                double total = 0;

                while ((line = reader.readLine()) != null) {
                    empty = false;
                    String[] p = line.split("\\|");
                    System.out.println("- " + p[0] + " to " + p[1] + " using " + p[2] + " (" + p[3] + " Frw) at " + p[4]);
                    total += Double.parseDouble(p[3]);
                }

                reader.close();

                if (empty) {
                    System.out.println("No bookings yet!");
                } else {
                    System.out.println("Total Fare: " + total + " Frw");
                }

            } catch (IOException e) {
                System.out.println("Error reading bookings: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        Booking booking = new Booking(sc.nextLine());

        while (true) {

            displayAvailable();

            System.out.println("\n1. Book Ride");
            System.out.println("2. Add Vehicles");
            System.out.println("3. Show My Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("From: ");
                    String from = sc.nextLine();

                    System.out.print("To: ");
                    String to = sc.nextLine();

                    String time;
                    while (true) {
                        System.out.print("Time (e.g., 10:30 AM): ");
                        time = sc.nextLine();
                        Matcher m = TIME_PATTERN.matcher(time);
                        if (m.matches()) break;
                        System.out.println("Invalid time format. Try again.");
                    }

                    System.out.println("Vehicle (1-BUS, 2-CAR, 3-BIKE): ");
                    int typeNum = sc.nextInt();
                    sc.nextLine();

                    VehicleType type;
                    if (typeNum == 1) type = VehicleType.BUS;
                    else if (typeNum == 2) type = VehicleType.CAR;
                    else type = VehicleType.BIKE;

                    System.out.print("Fare: ");
                    double fare = sc.nextDouble();
                    sc.nextLine();

                    booking.bookRide(from, to, type, fare, time);
                    break;
                }

                case 2: {
                    System.out.println("Add to which? (1-BUS, 2-CAR, 3-BIKE)");
                    int t = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Amount: ");
                    int amt = sc.nextInt();
                    sc.nextLine();

                    VehicleType vt;
                    if (t == 1) vt = VehicleType.BUS;
                    else if (t == 2) vt = VehicleType.CAR;
                    else vt = VehicleType.BIKE;

                    addVehicle(vt, amt);
                    break;
                }

                case 3:
                    booking.showBookings();
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
