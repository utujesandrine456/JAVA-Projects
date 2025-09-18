class StudentName{
    private String name;

    StudentName(String name){
        this.name = name;
    }

    public String getname(){
        return name;
    }
}
  

class StudentHello{
    private String  myname;

    StudentHello (){
        myname = "Kamana";
    }

    public String getname(){
        return myname;
    }
}

public class Student {
    public static void main(String[] args){
        StudentHello s = new StudentHello();
        StudentName s2 = new StudentName("Sandrine");

        System.out.println("New student: " + s.getname());
        System.out.println("New student: " + s2.getname());
        
    }
}

