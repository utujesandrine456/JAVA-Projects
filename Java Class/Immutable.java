public class Immutable{
    public static void main(String[] args){
        String name = "Sandrine";

        name.concat(" Bubuna");
        System.out.println("After concat (string): " + name);

        String newname = name.concat(" Bubuna");
        System.out.println("New String: " + newname);
    }
}
