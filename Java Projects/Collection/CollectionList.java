import java.util.*;



public class CollectionList {
    public static void main(String[] args) {
        List<Integer> c = new ArrayList<>();
        c.add(4);
        c.add(2);
        c.add(10);
        c.add(1);
        c.add(1,3);
        c.remove(0);

        System.out.println(c);

        for(Object obj:c){
            int num = (Integer) obj;
            System.out.println(num * 2);
        }


        Iterator<Integer> numbers = c.iterator();
        while(numbers.hasNext()){
            int num = numbers.next();
            System.out.println(num);
        }


        Collections.sort(c);
        System.out.println("Ascending Order: " +c);

        Collections.sort(c, Collections.reverseOrder());
        System.out.println("Descending Order: " + c);



        Map<String, Integer> marks = new HashMap<>();
        marks.put("Heloise", 90);
        marks.put("Christella", 90);
        marks.put("Heloise", 65);
        System.out.println(marks);
    }
}
