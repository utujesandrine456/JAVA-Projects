 interface Vehicle{
        void drive();
}


class Car implements Vehicle{
    public void drive(){
        System.out.println("My car is driving ...");
    }
}

class Animal {
    private String name;

    public Animal(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void makeSound(){
        System.out.println("Make sound mouw moumw mouwm !!");
    }
}


class Dog extends Animal{

    public Dog(String name){
        super(name);
    }


    @Override
    public void makeSound(){
        System.out.println(getName() + " says: Woof Woof !!");
    }

}


abstract class Animals {
    abstract void sound();
    void sleep(){
        System.out.println("Zzz...");
    }
}


class Dogs extends Animals {

    void sound() {
        System.out.println("Woof Woof");
    }
}


public class OOP{
    public static void main(String[] args){
        
        Dog d = new Dog("Bobby");
        d.makeSound();

        Vehicle myvehicle = new Car();
        myvehicle.drive();

        Dogs ds = new Dogs();
        ds.sound();
        ds.sleep();
    }
}



