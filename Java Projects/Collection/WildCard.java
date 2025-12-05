import java.util.*;


public class WildCard {
    public static void main(String[] args) {
        List<Integer> saaa = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Double> list3 = Arrays.asList(12.23, 234.4);
        display(saaa);
        display(list3);
        
    } 
    
    
    public static void display(List<? extends Number> sy) {
        for(Number var:sy){
            System.out.println(var);
        }
    }
}
