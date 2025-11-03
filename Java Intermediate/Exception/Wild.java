import java.util.*;


public class Wild {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Number> list2 = Arrays.asList(12, 3.14, 23.1, 232);
        List<String> list3 = Arrays.asList("Sandrine", "Gold", "Winner","Ange", "Benise");

        display(list1, 5);
        display(list2, 4);
        display(list3, 5);
    }


    public static void display(List<? extends Object> list, int size){
        System.out.println("List Elements:  ");
        for(int i=0; i<size; i++){
            Object sum = 0;
            sum =list.get(i);
            System.out.println(sum);
        }
        
    }

}
