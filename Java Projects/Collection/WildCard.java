import java.util.*;

public class WildCard {
    public static void main(String[] args) {
        List<Object> list1 = Arrays.asList(1,56,89, 90);
        List<Number> list2 = Arrays.asList(12, 234.4);
        display(list1);
        display(list2);

    } 
    
    
    public static void display(List<? super Number> list) {
        for(Object var:list){
            System.out.println(var);
        }
    }
}
