import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {
    int capacity;
    Queue<Integer> storage = new LinkedList<>();

    public ProducerConsumer(int capacity){
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException{
        if(storage.size() == capacity){
            wait();
        }

        storage.add(value);
        System.out.println("Produced " + value);
        notify();
    }


    public synchronized int consume() throws InterruptedException{
        if(storage.isEmpty()){
            wait();
        }

        int value = storage.poll();
        System.out.println("Consumed " + value);
        notify();
        return value;
    }

}

public class ProducerConsumermain{
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer(5);

        Thread t1 = new Thread(() -> {
            for(int i = 0; i<30; i++){
                try{
                    pc.produce(i);
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(() -> {
            for(int i = 0; i<20; i++){
                try{
                    pc.consume();
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });


        t1.start();
        t2.start();
    }
}
