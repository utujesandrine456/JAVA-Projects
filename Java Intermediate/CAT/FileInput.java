import java.io.*;


public class FileInput {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt");

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            System.out.println("File path: " + file.getAbsolutePath());
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());


            if (file.delete()) {
                System.out.println("File deleted successfully!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        try(FileWriter writer = new FileWriter("data.txt")){
            writer.write("Hello RCA Student!!!");
            writer.write("Filewrites writes text easily!!!");
            System.out.println("File written successfully");
        }catch(IOException e){
            e.printStackTrace();
        }


        try(FileReader reader = new FileReader("data.txt")){
            int ch;

            while((ch =reader.read()) != -1){
                System.out.print((char) ch);
            }
        }catch(IOException e){
            e.printStackTrace();
        }


        String message = "Hello message from Sandrine";
        try(FileOutputStream out = new FileOutputStream("Sandrine.txt")){
            byte[] bytes = message.getBytes();
            out.write(bytes);
            System.out.println("File Written successfully!!");
        }catch(IOException e){
            e.printStackTrace();
        }


        try(FileInputStream in = new FileInputStream("Sandrine.txt")){
            int ch;

            while((ch = in.read()) != -1 ){
                System.out.print((char) ch);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
