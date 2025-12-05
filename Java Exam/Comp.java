import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;


class Student implements Comparable<Student>{
    String name;
    int age;
    Student(String s, int a){this.name = s; this.age = a;}

    @Override
    public int compareTo(Student other) {
        return this.age - other.age;
    }

    @Override
    public String toString(){
        return name + ": " + age;
    }
}


class SortByName implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2){
        return s1.name.compareTo(s2.name);
    }
}


public class Comp{
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(new Student("Sandrine", 12), new Student("Chef", 15), new Student("Gold", 13)));
        Collections.sort(students);
        System.out.println(students);

        Collections.sort(students, new SortByName());
        System.out.println(students);

        Collections.sort(students, Collections.reverseOrder());
        System.out.println(students);
    }    
}
