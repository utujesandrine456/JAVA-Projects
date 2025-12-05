import java.util.LinkedList;
import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        int first = numbers.poll();
        int newfirst = numbers.peek();

        System.out.println("Original first number: " + first);
        System.out.println("New Number: " + newfirst);

    }
}
