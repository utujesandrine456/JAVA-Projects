public class Calculator{

    public int add(int a , int b){
        return a - b;
    }

    public void greet(String name){
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args){
        Calculator calc = new Calculator();

        int result = calc.add(5,3);
        System.out.println("The sum is: " + result);

        calc.greet("Prisca");
    }
}