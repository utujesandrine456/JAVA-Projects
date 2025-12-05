import java.io.*;


public class DataInput {
    public static void main(String[] args) {
        try(DataInputStream in = new DataInputStream(new FileInputStream("students.dat"))){
            int n = in.readInt();

            for(int i= 0; i < n; i++){
                int id = in.readInt();
                String name = in.readUTF();
                double mark = in.readDouble();
                boolean pass = in.readBoolean();
                System.out.printf("ID:%d  Name:%s   Marks:%.1f Passed:%b%n%n", id, name, mark, pass);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}


