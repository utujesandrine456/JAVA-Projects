import java.io.*;



class Employee implements Serializable {
    private String fName;
    private String lName;

    public Employee(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public String getfName() { return fName; }
    public void setfName(String fName) { this.fName = fName; }
    public String getlName() { return lName; }
    public void setlName(String lName) { this.lName = lName; }
}



public class EmployeeMain {
    public static void main(String[] args) {
        File file = new File("empl.ser");
        Employee em = new Employee("Damngirl","CoolKid");


        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(em);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            Employee em2 = (Employee) reader.readObject();
            System.out.println("First Name: " + em2.getfName());
            System.out.println("Last Name: " + em2.getlName());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
