import java.util.Arrays;
import java.util.*;

interface Multiplier {
    int multiplier(int x, int y);
}


// class Boy extends Thread {
//     public void run(){
//         List<String> students = new ArrayList<>(Arrays.asList("Student1", "Student2", "Student3", "Student4", "Student5"));

//         for(String student: students){
//             System.out.println(student);
//             try{
//                 Thread.sleep(10);
//             }catch(InterruptedException e){
//                 e.printStackTrace();
//             }
//         }
//     }
// }


// class Girl extends Thread {
//     public void run(){
//         List<String> students = new ArrayList<>(Arrays.asList("Student1", "Student2", "Student3", "Student4", "Student5"));

//         for(String student: students){
//             System.out.println(student);
//             try{
//                 Thread.sleep(10);
//             }catch(InterruptedException e){
//                 e.printStackTrace();
//             }
//         }
//     }
// }


class Counter{
    int count;
    public synchronized int counter(){return count++;};
}


public class MultiplierMain {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable counter1 = () -> {
            List<String> students = new ArrayList<>(Arrays.asList(
                "Student1", "Student2", "Student3", "Student4", "Student5"
            ));

            for (String student : students) {
                counter.counter();
                System.out.println("Thread 1 " + student);
                try { Thread.sleep(10); }
                catch (InterruptedException e) { e.printStackTrace(); }
            }
        };

        Runnable counter2 = () -> {
            List<String> students = new ArrayList<>(Arrays.asList(
                "Student1", "Student2", "Student3", "Student4", "Student5"
            ));

            for (String student : students) {
                counter.counter();
                System.out.println("Thread 2 " + student);
                try { Thread.sleep(5); }
                catch (InterruptedException e) { e.printStackTrace(); }
            }
        };

        Thread b = new Thread(counter1);
        Thread g = new Thread(counter2);

        b.start();
        g.start();

        b.join();
        g.join();

        System.out.println("Final Count = " + counter.count);
    }
}