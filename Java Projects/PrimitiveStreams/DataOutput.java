import java.io.*;
import java.util.*;



public class DataOutput {
    
    static class  Student {
        int id; String name; double mark; boolean pass;
        Student(int id, String name, double mark, boolean pass){
            this.id = id; this.name = name; this.mark = mark; this.pass = pass;
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(1, "Sandrine", 91, true),
            new Student(2, "Utuje", 57, false),
            new Student(3, "Bob", 87, true)
        );


        try(DataOutputStream out = new DataOutputStream(new FileOutputStream("students.dat"))){
            out.writeInt(students.size());

            for(Student s: students){
                out.writeInt(s.id);
                out.writeUTF(s.name);
                out.writeDouble(s.mark);
                out.writeBoolean(s.pass);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
