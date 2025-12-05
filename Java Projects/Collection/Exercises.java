import java.util.*;


public class Exercises {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("UWASE UTUJE Sandrine");
        names.add("Chef Kamali");
        names.add("Kalize Esther");
        names.add(1, "Heloise");
        names.remove(3);

        for(String n:names){
            System.out.println("Name is: " + n);
        }
    }
     
}
