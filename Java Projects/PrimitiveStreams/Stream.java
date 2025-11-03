import java.io.*;


public class Stream {
    public static void main(String[] args) {
        File file = new File("data.dat");

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            dos.writeInt(5);
            dos.writeUTF("hello");
            dos.writeBoolean(true);
        }catch(IOException e){
            e.printStackTrace();
        }


        try(DataInputStream reader = new DataInputStream(new FileInputStream(file))){
            System.out.println(reader.readInt());
            System.out.println(reader.readUTF());
            System.out.println(reader.readBoolean());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


