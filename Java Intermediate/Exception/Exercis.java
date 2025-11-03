import java.util.*;

class Student{
    String name;
    int id;

    Student(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString(){
        return name + "( ID:  " + id + ")";
    }
}


public class Exercis {
    public static void main(String[] args) {
        Map<Student, String> students = new HashMap<>();

        Student s1 = new Student("Sandrine ", 101);
        Student s2 = new Student("UTUJE ", 102);
        Student s3 = new Student("Bubuna ", 103);

        students.put(s1, "Frontend Developer");
        students.put(s2, "UI/UX Designer");
        students.put(s3, "Backend Developer");


        for(Map.Entry<Student, String> stud: students.entrySet()){
            System.out.println(stud.getKey() +  " -> "  + stud.getValue());
        }

    }
}
