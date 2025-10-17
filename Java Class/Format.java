import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Format {
   public Format() {
   }

   public static void main(String[] var0) {
      System.out.printf("%d %d %d %n", 10, 20, 30);

      double var1 = 3.14159265359;
      System.out.printf("%.2f %.4f %.6f %n", var1, var1, var1);

      System.out.printf("%-15s|%-5d%n", "Sandrine", 12);
      System.out.printf("%-15s|%-5d%n", "UTUJE", 17);

      System.out.printf("%,d%n", 12000000);

      double number = 12356432.89;
      System.out.printf(Locale.US, "US number: %, .2f%n", number);
      System.out.printf(Locale.FRANCE, "French number: %, .2f%n", number);

      double money = 1999.99;
      System.out.printf(Locale.US, "US Money: %,.2f%n", money);
      System.out.printf(Locale.FRANCE, "French Money: %,.2f%n", money);
      System.out.printf(Locale.JAPAN, "Japanesse Money: %,.2f%n", money);

      System.out.printf("%-10s|%-10s|%-10s|%-10s%n", "Name", "Price", "Quantity", "Product");

      Scanner sc = new Scanner(System.in);
      sc.useLocale(Locale.FRANCE);
      System.out.println("Print a frech number:");
      double num = sc.nextDouble();
      System.out.printf(Locale.US, "US number: %,.2f", num);
      sc.close();

      LocalDateTime now = LocalDateTime.now();
      System.out.println("Today is:" + now);
      System.out.printf("Today is: %s%n", now);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
      System.out.printf("Farmatted date and time is: %s%n", now.format(formatter));

   }
}