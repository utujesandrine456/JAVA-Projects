import java.io.*;
import java.util.Scanner;






public class IOstream {
    public static void main(String[] args) throws IOException {
        // FileInputStream source = null;
        // FileOutputStream target = null;

        // try{
        //     source = new FileInputStream("./data.txt");
        //     target = new FileOutputStream("./Destination.txt");

        //     int content;

        //     while((content = source.read(null)) != -1){
        //         target.write(content);
        //     }
        // }finally{
        //     source.close();
        //     target.close();
        // }



        // File file = new File("./data.txt");
        // try(PrintWriter writer = new PrintWriter(new FileWriter(file, true))){
        //     writer.println("Wake up ....");
        //     writer.println("Still in java ...");
        // }catch(IOException e){
        //     e.getMessage();
        // }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data , type 'exit' to quit");
        String line;

        while(sc.hasNext()){
            line = sc.nextLine();
            if(line.equalsIgnoreCase("exit"))
                break;
            System.out.println("Entered:" + line);
        }
        sc.close();
    }
}
