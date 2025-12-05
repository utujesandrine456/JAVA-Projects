import java.util.*;


class SortByLastDigit implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        int lastA = a % 10;
        int lastB = b % 10;
        return lastA - lastB; 
    }
}


public class IntegerDigit {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(45, 32, 67, 89, 12, 90, 23);

        // integers.sort(Comparator.comparingInt( num -> num % 10));
        // System.out.println("Sorted By last digit: " + integers);

        Collections.sort(integers, new SortByLastDigit());
        System.out.println("Comparator: " + integers);
    }
}



