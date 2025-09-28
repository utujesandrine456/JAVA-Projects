// class Student{
//     private String name;
//     private int age;
//     private char grade;

//     public Student(String name, int age, char grade){
//         this.name = name;
//         this.age = age;
//         this.grade = grade;
//     }

//     public String displayinfo(){
//         return "Name: " + name + ", Age: " + age + ", Grade: " + grade;
//     }
// }


class Animal{
    public void makeSound(){
        System.out.println("Animal makes sound");
    }
}


// class Cat extends Animal{
//     public void makeSound(){
//         System.out.println("Meow");
//     }
// }


// class Dog extends Animal{
//     public void makeSound(){
//         System.out.println("Woof");
//     }
// }


// interface Vehicle{
//     void start();
// }

// class Car implements Vehicle{
//     @Override
//     public void start(){
//         System.out.println("Car started ...");
//     }
// }


// class Bike implements Vehicle{
//     @Override
//     public void start(){
//         System.out.println("Bike started ...");
//     }
// }


class BankAccount {
    private double balance;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public double getter(){ return balance; } 

    public void setter(double balance) {
        this.balance = balance;
    }
}


abstract class Shape {
    abstract double area();
}


class Circle extends Shape{
    double radius;
    
    Circle(double radius){
        this.radius = radius;
    }

    public double area(){
        return Math.PI * radius * radius;
    }
}


class Rectangle extends Shape{
    double height;
    double width;

    Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }

    public double area(){
        return height * width;
    }
}


class NumberChecker{
    public  int checkEvenOdd(int number){
        if(number % 2 == 0){
            System.out.println("The number is Even");
            return 1;
        } else{
            System.out.println("The number is Odd");
            return 0;
        }
    }
}


interface Playable{
    public void play();
}

abstract class Instrument{
    abstract void sound();
}

class Guitar extends Instrument implements Playable{
    public void play(){
        System.out.println("Playing the guitar");
    }

    public void sound(){
        System.out.println("Guitar sound");
    }
}


class Piano extends Instrument implements Playable{
    public void play(){
        System.out.println("Playing the piano");
    }

    public void sound(){
        System.out.println("Piano sound");
    }
}

public class Exercise {
    public static void main(String[] args){

        // Student s1 = new Student("Alice", 20, 'A');
        // Student s2 = new Student("Baraka", 17, 'B');

        // System.out.println(s1.displayinfo());
        // System.out.println(s2.displayinfo());


        // Animal mycat = new Cat();
        // Animal mydog = new Dog();

        // mycat.makeSound();
        // mydog.makeSound();

        Animal[] animals = new Animal[2];

        // animals[0] = new Cat();
        // animals[1] = new Dog();


        for(int i = 0; i < animals.length; i++){
            animals[i].makeSound();
        }

        // Vehicle[] vehicles = new Vehicle[2];

        // vehicles[0] = new Car();
        // vehicles[1] = new Bike();

        // for(int i = 0; i < vehicles.length; i++){
        //     vehicles[i].start();
        // }


        BankAccount myaccount = new BankAccount(23424124125124.098890);
        System.out.println("Your account balance is: " + myaccount.getter());

        myaccount.setter(1.224214321);
        System.out.println("You new balance is: " + myaccount.getter());
       


        Shape[] shapes = new Shape[2];

        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);

        for(int i = 0; i < shapes.length; i++){
            System.out.println(shapes[i].area());
        }


        NumberChecker checker = new NumberChecker();

        for(int i = 1; i <= 20; i++){
            checker.checkEvenOdd(i);
        }
        


        Playable[] instruments = new Playable[2];

        instruments[0] = new Guitar();
        instruments[1] = new Piano();

        for(int i = 0; i < instruments.length; i++){
            instruments[i].play();
            ((Instrument)instruments[i]).sound();
        }


        for (Playable p : instruments){
            p.play();
            ((Instrument)p).sound();
        }

        
    }
}


