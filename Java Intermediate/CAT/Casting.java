
class Animal{
    String makeSound(){
        System.out.println("Animal make sound");
        return "Sandrine";
    }

    public String toString(){
        return makeSound();
    }
}


class Dog extends Animal{
    String makeSound(){
        System.out.println("Bark !!!");
        return "Poppy";
    }

    void guard(){
        System.out.println("Protect");
    }

    
}



public class Casting{
    public static void main(String[] args) {
        Animal a = new Dog();
        a.makeSound();

        Dog d = (Dog) a;
        d.guard();
        
        System.out.println(a);
    }
}