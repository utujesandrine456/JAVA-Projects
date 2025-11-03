import java.util.Objects;

class Student{
    String name;
    int age;

    @Override
    public int hashCode(){
        return Objects.hash(name , age);
    }


    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Student)) return false;

        Student s = (Student) obj;
        return this.age == s.age && this.name.equals(s.name);
    }
}


public class Hash {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Sandrine";
        s1.age = 16;

        Student s2= new Student();
        s2.name = "Sandrine";
        s2.age= 16;


        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        System.out.println(s1.hashCode());
        System.out.println(s1.hashCode());
    }    
}
