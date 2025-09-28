class Computer {
    String brandname;
    String color;
    
    Computer(String brandname, String color){
        this.brandname = brandname;
        this.color = color;
    }

    void playmusic(){
        System.out.println("Playing with computer");
    }

    String display(){
        return brandname;
    }
};


class Laptop extends Computer{
    String number;
    
    Laptop(String brandname, String color, String number ){
        super(brandname, color);
        this.number = number;
    };

    String display(){
        return super.display();
    }

    void playmusic(){
        System.out.println("Playing using Laptop");
    };
}


class Desktop extends Computer{
    
    Desktop(String brandname, String color ){
        super(brandname, color);
    };

    String display(){
        return super.display();
    }

    void playmusic(){
        System.out.println("Playing using Laptop");
    };
}



public class Super {
    public static void main(String[] args){
        Computer laptop = new Laptop("HP computer", "white", "12");
        Computer desktop = new Desktop("Desktop computer", "white");
        laptop.playmusic();
        System.out.println("Laptopinfo: " + laptop.display());

        desktop.playmusic();
        System.out.println("Laptopinfo: " + desktop.display());
    }
}
