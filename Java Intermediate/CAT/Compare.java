import java.util.*;


class Employee{
    private String firstname;
    private String lastname;
    private int age;
    private double salary;


    Employee(String firstname, String lastname, int age, double salary ){
        this.firstname  = firstname;
        this.lastname  = lastname;
        this.age  = age;
        this.salary  = salary;
    }   

    String getFirst(){
        return firstname;
    }

    void setFirst(String firstname){
        this.firstname = firstname;
    }

    String getSecond(){
        return lastname;
    }

    void setSecond(String lastname){
        this.lastname = lastname;
    }

    int getAge(){
        return age;
    }

    void setAge(int age){
        this.age = age;
    }

    double getSalary(){
        return salary;
    }

    void setSalary(double salary){
        this.salary = salary;
    }
}


class SortAge implements Comparator<Employee>{

    @Override
    public int compare(Employee s1, Employee s2){
        return s1.getAge() - s2.getAge();
    }
}


public class Compare{
    public static void main(String[] args) {
        List<Employee> students = new ArrayList<>();
        students.add(new Employee("Sandrine", "UTUJE", 16, 1000000));
        students.add(new Employee("Amani", "ISHIMWE", 11, 2000000));
        students.add(new Employee("Benise", "GIHOZO", 13, 3000000));

        Collections.sort(students, new SortAge());
        
        for(Employee s: students){
            System.out.printf("Name: %s  Age: %d  Salary: %.2f \n", s.getFirst(), s.getAge(), s.getSalary());
        }
    }
}