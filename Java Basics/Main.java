// Frist Hello World !! in Java

// public class Main{
//     public static void main(String[] args){
//             System.out.println("Hello, World!!!");
//     }
// }



// Declaration of variable , operators and control statement 

public class Main{
    public static void main(String[] args){
        int age = 12;
        char grade = 'B';
        String name = "Sandrine";
        int another = 20;
        

        System.out.println("My name is " + name);
        System.out.println("My age is " + age);
        System.out.println("My grade is " + grade);
        System.out.println("Another number is " + another);

        String name1 = new String("Joshua");
        String name2 = new String("Joshua");

        System.out.println(name1 + name2);
        loop(args);
    }

    public static void control(){

        int number =  17;

        if(number <= 16){
            System.out.println("You are still young ");
        }else{
            System.out.println("You are now adult ");
        }
    }

    public static void operators(){
        int a = 10;
        int b = 5;

        System.out.println("The sum is " + (a + b));
        System.out.println("The difference is " + (a - b));
        System.out.println("The product is " + (a * b));
        System.out.println("The division is " + (a / b));
        System.out.println("The modulus is " + (a % b));
        System.out.println("The power is " + (Math.pow(a, b)));
    }


    public static void loop(String[] args){
        System.out.println("Number of arguments: " + args.length);

        for(int i = 0; i < args.length; i++){
            System.out.println(("Argument " + i + ": " + args[i]));
        }

        int j = 12;
        while(j <= 20){
            System.out.println("The number is " + j);
            j++;
        }
    }

};





