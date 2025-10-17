import java.io.*;



public class FileHandler {
    public static void main(String[] args) {
        String data = "Hello RCA student!!";


        try(FileOutputStream out = new FileOutputStream("./data.txt")){
            byte[] bytes = data.getBytes();
            out.write(bytes);
        }catch(IOException e){
            e.printStackTrace();
        }


        try(FileReader reader= new FileReader("./data.txt")){
            FileWriter writer = new FileWriter("./Destination.txt");

            int content;
            while((content = reader.read()) != -1){
                writer.write((char)content);
            }

            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }


        try (FileReader reading = new FileReader("./Destination.txt")) {
            int content;
            while ((content = reading.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
