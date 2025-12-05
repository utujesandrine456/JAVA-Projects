import java.io.*;
import java.util.*;
import java.util.List;



class Student{
    String name;
    int age;
    double averageMark;


    Student(String name, int age, double averageMark){
        this.name = name;
        this.age = age;
        this.averageMark = averageMark;
    }
}

public class StudentSystem {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Sandrine", 16, 91.2),
            new Student("Sandra", 17, 97.3),
            new Student("Sonia", 20, 92.1 )
        );

        try(DataOutputStream out = new DataOutputStream(new FileOutputStream("students.bin"))){
            out.writeInt(students.size());

            for(Student s: students){
                out.writeUTF(s.name);
                out.writeInt(s.age);
                out.writeDouble(s.averageMark);
            }

            System.out.println("Data written successfully !!!");
        }catch (Exception e) {
           e.printStackTrace();
        }

        try(DataInputStream in = new DataInputStream(new FileInputStream("students.bin"))){
            int n = in.readInt();

            for(int i =0; i< n; i++){
                String name = in.readUTF();
                int age = in.readInt();
                double marks = in.readDouble();
                System.out.printf("Name: %s  Age: %d  Marks: %.2f \n", name, age, marks);
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
