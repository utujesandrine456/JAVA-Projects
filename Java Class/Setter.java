

class Animal {
    private String name;

    Animal(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
        System.out.println(name);
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


public class Setter{
    public static void main(String[] args){
        Animal animal = new Dog("Poppy");
        animal.getName();
        animal.setName("Bobby");
    }
}


