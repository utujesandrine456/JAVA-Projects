import java.io.*;

class CountLine{
    void countlines() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int count = 0;

        while(br.readLine() != null){
            count++;
        }

        br.close();
        System.out.println("Total lines: " + count);
    }
}

class WordsToUpperCase{
    void touppercase() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line.toUpperCase());
        }
        br.close();
    }
}


class CopyFile{
    void copyfile() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("source.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("destination.txt"));

        String line;
        while((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();
        System.out.println("File Copied !!!");
    }
}

public class Streams {
    public static void main(String[] args) throws Exception{
        CountLine lines = new CountLine();
        lines.countlines();

        WordsToUpperCase words = new WordsToUpperCase();
        words.touppercase();


        CopyFile file = new CopyFile();
        file.copyfile();
    }    
}
