import java.util.*;
class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private int age;
    private int salary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String firstName, String lastName, int age, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
    

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(other.salary,this.salary);
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + age;
        result = prime * result + salary;
        return result;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (age != other.age)
            return false;
        if (salary != other.salary)
            return false;
        return true;
    }
}


class SortAge implements Comparator<Employee>{
    @Override
    public int compare(Employee em1, Employee em2) {
        return Integer.compare(em1.getAge(), em2.getAge());
    }

}


public class EmployeeMain {
    public static void main(String[] args) {
//        List<Employee> list = new ArrayList<>();
//        list.add(new Employee("Wihogora", "Florence", 16, 1000));
//        list.add(new Employee("Amani", "Samuel", 20, 2000));
//        list.add(new Employee("Ishala", "Gold", 17, 1500));
//        Collections.sort(list, new SortAge());
//        System.out.println(list);
//
//        Comparator<Employee> com = new Comparator<Employee>() {
//            @Override
//            public int compare(Employee em1, Employee em2) {
//                if(em1.getSalary() < em2.getSalary())
//                    return 1;
//                else
//                    return -1;
//            }
//        };
//        Collections.sort(list);
//        System.out.println(list);

        Employee emp1 = new Employee("Amani", "Samuel", 20, 2000);
        Employee emp2 = new Employee("Amani", "Samuel", 20, 2000);
        Set<Employee> set = new HashSet<>();
        set.add(emp1);
        set.add(emp2);
        boolean val = emp1.equals(emp2);
        System.out.println(val);
        System.out.println(set.size());

        Map<Employee, String>map = new HashMap<>();
        map.put(emp1, "first value");
        map.put(emp2, "duplicate value");
    }
}