package mashq1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    int balance;
    private Lock lock = new ReentrantLock();

    public void increaseBalance() {
       this.balance += 1;
       try{
           lock.lock();
           balance +=1;
       } finally {
          lock.unlock();
       }
    }
   public void decreaseBalance() {
       this.balance -= 1;
   }
   public int getBalance() {
       return this.balance;
   }
}
