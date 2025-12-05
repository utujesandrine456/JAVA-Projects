import java.util.ArrayList;
import java.util.List;

class Printer<Ts>{
    Ts valueToPrint;

    public Printer(Ts valueToPrint){
        super();
        this.valueToPrint = valueToPrint;
    }

    public void print(){
        System.out.println("Value : " + valueToPrint);
    }

    public void showNumber(){
        List<Number> numbers = new ArrayList<>();

        numbers.add(12);
        numbers.add(12.23);
        numbers.add(101233212L);
        numbers.add(3.14f);

        for(Number n : numbers){
            System.out.println("List Value: " + n);
        }
    }

}


class PrintList {
    void printlist(List<? extends Number> numbers) {
        System.out.println("List 1: ");
        
        for (Number n : numbers) {
            System.out.println(n);
        }
    }
}


public class PrinterMain {
    public static void main(String[] args) {
        Printer<Double> printer = new Printer<>(5.5);
        printer.print();

        Printer<Integer> printer2 = new Printer<>(123);
        printer2.print();

        Printer<String> printer3 = new Printer<>("Name");
        printer2.print();

        System.out.println(displayinfo(12.3, 16));

        printer.showNumber();


        PrintList lists = new PrintList();
        List<Integer> num1 = List.of(1, 2, 4, 5, 6);
        List<Double> num2 = List.of(12.2, 12.3, 13.4, 14.5);
        List<Long> num3 = List.of(132234L, 121323L);

        
        lists.printlist(num1);
        lists.printlist(num2);
        lists.printlist(num3);

    }
    
    
    public static <Stude, S2> Stude displayinfo(Stude par1, S2 par2){
        return par1;
    }
}