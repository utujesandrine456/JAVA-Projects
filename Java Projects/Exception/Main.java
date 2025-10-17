import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = input.nextInt();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        try {
            // Handle division by zero
            if (num2 == 0) {
                throw new ArithmeticException("Cannot divide by zero!");
            }

            // Handle custom age rule
            if (age < 18) {
                throw new AgeException("You are under age!");
            }

            int result = num1 / num2;
            System.out.println("The result from the server is: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());

        } catch (AgeException e) {
            System.out.println("Age Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected error occurred!");

        } finally {
            System.out.println("Execution Completed!");
            input.close();
        }
    }
}
