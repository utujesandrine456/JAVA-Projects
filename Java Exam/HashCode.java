import java.util.Objects;

class Employee{
    String name;
    int id;

    @Override
    public int hashCode(){
        return Objects.hash(name, id);
    }


    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        Employee other = (Employee) obj;
        return Objects.equals(this.name, other.name) && this.id == other.id;
    }
}


public class HashCode{
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.name = "John";
        e1.id = 1;

        Employee e2 = new Employee();
        e2.name = "John";
        e2.id = 1;
        
        Employee e3 = e2;
        System.out.println(e3 == e2);
        System.out.println(e3 == e1);
        System.out.println(e1 == e2);
        System.out.println(e1.equals(e2));
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}


