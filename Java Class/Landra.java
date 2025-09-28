class StudentName{
    String name = "sandrine";

    StudentName(String name){
        this.name = name;
    }

    String display(){
        return name;
    }

}


public class Landra {
    public static void main(String[] args){
        StudentName s1 = new StudentName("Landra");
        System.out.println(s1.display());

    }

   
}
