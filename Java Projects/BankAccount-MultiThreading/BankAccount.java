import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;



public class BankAccount{
    static final int TOTAL_TRANSACTIONS = 50;
    static final AtomicInteger totalTransactions = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(100, 300);

        Thread[] depositors = new Thread[3];
        Thread[] withdrawers = new Thread[3];

        for(int i =0; i<depositors.length; i++){
            depositors[i] = new Depositor(account, 10, 100, "Depositor-" + (i + 1));
        }

        for(int i=0; i<withdrawers.length; i++){
            withdrawers[i] = new Withdrawer(account, 10,80, "Withdrawer-" + (i + 1));
        }


        for(Thread t: depositors) t.start();
        for(Thread t : withdrawers) t.start();

        for(Thread t: depositors) t.join();
        for(Thread t: withdrawers) t.join();

        System.out.println("\n*** All threads finished ***");
        System.out.printf("Final balance: %d\n", account.getBalance());
        System.out.printf("Total successful transactions recorded: |%d (target was %d)\n", totalTransactions.get(), TOTAL_TRANSACTIONS);
    }


    static class Account {
        private int balance;
        private final Integer maxBalance;

        public Account(int initialBalance , Integer maxBalance){
            this.balance = initialBalance;
            this.maxBalance = maxBalance;
        }


        public synchronized int getBalance(){
            return balance;
        }

        public synchronized boolean deposit(int amount){
            if(totalTransactions.get() >= TOTAL_TRANSACTIONS){
                notifyAll();
                return false;
            }

            while(maxBalance != null && (balance + amount) > maxBalance){
                try{
                    if(totalTransactions.get() >= TOTAL_TRANSACTIONS){
                        notifyAll();
                        return false;
                    }
                    wait();
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
            
            balance += amount;
            int done = totalTransactions.incrementAndGet();

            System.out.printf("[%s] Deposit +%d => balance= %d (transactions=%d)\n", Thread.currentThread().getName(), amount, balance, done);
            notifyAll();

            if(done >= TOTAL_TRANSACTIONS){
                notifyAll();
            }
            return true;
        }  
        
        
        public synchronized boolean withdraw(int amount){
            if(totalTransactions.get() >= TOTAL_TRANSACTIONS){
                notifyAll();
                return false;
            }

            while(balance < amount){
                try{
                    if(totalTransactions.get() >= TOTAL_TRANSACTIONS){
                        notifyAll();
                        return false;
                    }
                    wait();
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    return false;
                }
            }

            balance -= amount;
            int done = totalTransactions.incrementAndGet();

            System.out.printf("[%s] Withdraw -%d => balance= %d (transactions=%d)\n", Thread.currentThread().getName(), amount, balance, done);
            notifyAll();

            if(done >= TOTAL_TRANSACTIONS){
                notifyAll();
            }

            return true;
        }
    }


    static class Depositor extends Thread{
        private final Account account;
        private final int min, max;
        private final Random rnd = new Random();

        public Depositor(Account account, int min, int max, String name) {
            super(name);
            this.account = account;
            this.min = min;
            this.max = max;
        }

        @Override
        public void run(){
            while(totalTransactions.get() < TOTAL_TRANSACTIONS){
                int amount = rnd.nextInt(max -min + 1) + min;
                account.deposit(amount);

                try{ 
                    Thread.sleep( 40 + rnd.nextInt(60));
                }catch(InterruptedException e) {
                    break;
                }
            }
        }
    }


    static class Withdrawer extends Thread{
        private final Account account;
        private final int min, max;
        private final Random rnd = new Random();

        public Withdrawer(Account account, int min, int max, String name) {
            super(name);
            this.account = account;
            this.min = min;
            this.max = max;
        }


        @Override
        public void run(){
            while(totalTransactions.get() < TOTAL_TRANSACTIONS){
                int amount = rnd.nextInt(max - min + 1) + min;
                account.withdraw(amount);
                try{
                    Thread.sleep(40 + rnd.nextInt(60));
                }catch(InterruptedException e){
                    break;
                }
            }
        }
    }
}