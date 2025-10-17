class Employee {
    String work;

    Employee(String work){
        this.work = work;
    }

    public String work(){
        return "I am a " + work;
    }

    
}


class Manager extends Employee{
    String time;

    Manager(String time, String work){
        super(work);
        this.time = time;
    }

    @Override
    public String work(){
        return super.work();
    }


    public String conductMeeting(){
        return "The meeting will start at " + time;
    }
}

// class Animal{
//     public void sound(){
//         System.out.println("I make sound");
//     }
// }


// class Dog extends Animal{
   
//     public void bark(){
//         System.out.println("I am barking !!!");
//     }
    
// }


// class Student{
//     static int count;

//     static void displayCount(){
//         System.out.println("The number of students created are: " + count);
//     }
// }


// class BankAccount{
//     double amount;
//     double time;
//     static double interestRate;

//     BankAccount(double amount,  double time, double interestRate ){
//         this.amount = amount;
//         this.time = time;
//         this.interestRate = interestRate;
//     }


//     void calculate(){
//         double simpleinterest = (amount * time * interestRate) / 100;
//         System.out.println("The simple interest is : " + simpleinterest);
//     }


//     double getter(){
//         return interestRate;
//     }


//     void setter(double interestRate){
//         this.interestRate = interestRate;

//         calculate();
//     }

// }


class Vehicle{
    Vehicle(){
        System.out.println("I am riding");
    }
}


// class Car extends Vehicle{
//     Car(){
//         super();
//         System.out.println();
//     }
// }


class September19{
    public static void main(String[] args){
        Employee Sandrine = new Manager("9:23", "Frontend Developer");
        System.out.println(Sandrine.work());

        Manager Bubuna = (Manager) Sandrine;
        System.out.println(Bubuna.conductMeeting());


        // Animal dog = new Dog();
        // dog.sound();

        // Dog dog2 = (Dog) dog;
        // dog2.bark();


        // BankAccount sandrine = new BankAccount(200000.00, 2.00, 5.00);
        // BankAccount landra = new BankAccount(750000.00, 3.00, 16.00);
        // BankAccount bubuna = new BankAccount(200000.00, 2.00, 5.00);
        // BankAccount rodger = new BankAccount(750000.00, 3.00, 16.00);
        
        // sandrine.calculate();
        // landra.calculate();
        // bubuna.calculate();
        // rodger.calculate();

        // sandrine.getter(); sandrine.setter(26);
        // landra.getter(); landra.setter(22);
        // bubuna.getter(); bubuna.setter(6);
        // rodger.getter(); rodger.setter(36);
    }
}