import java.util.*;


public class CollectionList {
    public static void main(String[] args) {
        // List<String> names  = new ArrayList<>();
        // names.add("John");
        // names.add("Anna");
        // names.add("John");

        // for(String name: names){
        //     System.out.println(name);
        // }

        // Set<String> unique = new HashSet<>();
        // unique.add("John");
        // unique.add("John");
        // unique.add("Winner");

        // for(String un : unique ){
        //     System.out.println(un);
        // }

        // Map<String, Integer> ages = new HashMap<>();
        // ages.put("John", 25);
        // ages.put("Anna", 22);
        // ages.put("Anna", 30);


        // for(String key: ages.keySet()){
        //     System.out.println("Key " + key + "->" + " Value " + ages.get(key));
        // }    


        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Eve");
        names.remove(2);

        for(String name : names){
            System.out.println(name);
        }



        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5,1,9,3,7));
        Collections.sort(numbers);
        System.out.println("Ascending Order: " + numbers);

        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Descending Order: " + numbers);



        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 3, 5));
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();


        for(Integer n : nums){
            if(!seen.add(n)){
                duplicates.add(n);
            }
        }

        System.out.println("Duplicates: " + duplicates);


        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("C", "D"));

        list1.addAll(list2);
        System.out.println("MergedList: " + list1);



        ArrayList<Integer> duplicate = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 4));
        Set<Integer> set = new HashSet<>(duplicate);
        System.out.println("Unique Values: " + set);

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        set1.retainAll(set2);
        System.out.println("Common Elements: " + set1);


        Set<String> tree = new TreeSet<>();
        tree.add("Banana");
        tree.add("Dpple");
        tree.add("Cherry");

        System.out.println(tree);


        Set<Integer> studentIDs = new HashSet<>(Arrays.asList(101, 102, 103));
        System.out.println(studentIDs.contains(102));
        System.out.println(studentIDs.contains(105));


        Map<String, Integer> marks = new HashMap<>();
        marks.put("Alice", 85);
        marks.put("Bob", 90);
        marks.put("Charlie", 78);
        marks.put("Daniel", 100);

        for(Map.Entry<String, Integer> entry : marks.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        Map<String, String> countries = new TreeMap<>();
        countries.put("USA", "Washington");
        countries.put("India", "New Delhi");
        countries.put("Japan", "Tokyo");

        System.out.println(countries);
    }   
}
