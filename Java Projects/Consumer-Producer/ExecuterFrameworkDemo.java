import java.util.concurrent.*;
import java.util.*;

// class Task implements Runnable{
//     int num ;

//     public Task(int num){
//         this.num = num;
//     }

//     @Override
//     public void run(){
//         System.out.println("Task " + num + " has started");

//         for(int i = num; i<num * 10; i++){
//             System.out.println(i);
//         }

//         System.out.println("Task " +num + " has completed" );
//     }
// }

class TaskReturn implements Callable<Integer>{
    int num ;

    TaskReturn(int num){
        this.num = num;
    }
        
    @Override
   public Integer call() throws Exception{
        return num;
   }

}


public class ExecuterFrameworkDemo {
    public static void main(String[] args) {
        ExecutorService executer = Executors.newFixedThreadPool(3);

        // Future<Integer> f1 = executer.submit(new TaskReturn(1));
        // Future<Integer> f2 = executer.submit(new TaskReturn(2));
        // Future<Integer> f3 = executer.submit(new TaskReturn(3));

        List<Callable<Integer>> tasks = new ArrayList<>();

        tasks.add(new TaskReturn(4));
        tasks.add(new TaskReturn(5));
        tasks.add(new TaskReturn(6));

        try{
            // List<Future<Integer>> futures = executer.invokeAll(tasks);
            Integer first = executer.invokeAny(tasks);

            System.out.println("Result = " + first);
            // for(int i = 0; i < futures.size(); i++){
            //     System.out.println("Task " + (i + 1) + " result = " + futures.get(i).get());
            // }
            
        }catch(InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        // try{
        //     System.out.println("Result1 = " + f1.get());
        //     System.out.println("Result1 = " + f2.get());
        //     System.out.println("Result1 = " + f3.get());
        // }catch(InterruptedException  | ExecutionException e){
        //     e.getMessage();
        // }

        executer.shutdown();
    }
}
