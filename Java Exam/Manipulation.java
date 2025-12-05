import java.util.regex.*;

public class Manipulation {
    public static void main(String[] args) {
        String s1 = "12345";
        System.out.println(s1.matches("\\d+"));

        String s2 = "Java";
        System.out.println(s2.matches("[a-zA-Z]+"));

        String s3 = "learning";
        System.out.println(s3.matches(".*ing$"));

        String s4 = "Room 8, block 13";
        Matcher m4 = Pattern.compile("\\d+").matcher(s4);

        while(m4.find()){
            System.out.println(m4.group() + " ");
        }
        System.out.println();


        String s5 = "Apt 205";
        System.out.println(s5.replaceAll("//d", "*"));


        String s6 = "Hello java CODE now";
        Matcher m6 = Pattern.compile("\\b[a-z]+\\b").matcher(s6);
        
        while(m6.find()){
            System.out.println(m6.group() + " ");
        }
    }   
}
