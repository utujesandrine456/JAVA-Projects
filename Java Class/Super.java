class Computer {
    String brandname;
    
    Computer(String brandname){
        this.brandname = brandname;
    }

    void playmusic(){
        System.out.println("Playing with computer");
    }

    String display(){
        return brandname;
    }
};


class Laptop extends Computer{
    
    Laptop(String brandname ){
        super(brandname);
    };

    String display(){
        return super.display();
    }

    void playmusic(){
        System.out.println("Playing using Laptop");
    };
}


class Desktop extends Computer{
    
    Desktop(String brandname ){
        super(brandname);
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
        Computer laptop = new Laptop("HP computer");
        Computer desktop = new Desktop("Desktop computer");
        laptop.playmusic();
        System.out.println("Laptopinfo: " + laptop.display());

        desktop.playmusic();
        System.out.println("Laptopinfo: " + desktop.display());
    }
}

