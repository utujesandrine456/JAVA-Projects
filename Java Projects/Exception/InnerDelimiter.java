import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;


class Delimiter{
    public static void main(String[] args) {
        // String data = "Honorine bonbon  12";
        // Scanner sc = new Scanner(data);
        // String token1 = sc.next();
        // String token2 = sc.next();
        // int token4 = sc.nextInt();
        // System.out.println("Name " + token1 + " bonbon " + token4);

        String data2 = "17/10/2025";
        Scanner sc = new Scanner(data2);
        sc.useDelimiter("/");

        int token5 = sc.nextInt();
        int token6 = sc.nextInt();
        int token7 = sc.nextInt();

        int sum = token5 + token6 + token7;       
        System.out.println("The sum of numbers is: " + sum);
        sc.close();
    }
}


public class InnerDelimiter {
    public static void main(String[] args) {
        double num = 500000.465;
        NumberFormat usFormat = NumberFormat.getInstance(Locale.US);
        NumberFormat frFormat = NumberFormat.getInstance(Locale.FRANCE);
        System.out.println("French Format: " + frFormat.format(num));
        System.out.println("US Format: " + usFormat.format(num));
    }
    
}


class Printing{
    public static void main(String[] args) {
        System.out.printf("%b%n", 7 < 6);
    }
}


