public class Immutable{
    public static void main(String[] args){
        String name = "Sandrine";

        name.concat(" Bubuna");
        System.out.println("After concat (string): " + name);

        String newname = name.concat(" Bubuna");
        System.out.println("New String: " + newname);


        String string = "UWASE";
        String string2 = string;
        String string3 = "UWASE";

        System.out.printf("Bolean:%b\n", string == string2);
        System.out.printf("Bolean:%b\n", string == string3);
        System.out.printf("Bolean:%b\n", string.equals(string3));
        System.out.printf("Bolean:%b\n", string.equals(string2));
        
    }
}
