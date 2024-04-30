
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class SharedResource {
    private int sharedValue = 0;
    private Lock lock = new ReentrantLock();
    public void add(int value) {
    lock.lock(); 
    try{
        sharedValue += value;
    }
    finally{
        lock.unlock(); 
    }
}
    public void subtract(int value) {
        lock.lock(); //Adding the lock before accessing the shared value
    try{
        sharedValue -= value;
    }
    finally{
        lock.unlock(); //Releasing the lock after completion
    }
}
    public int getSharedValue() {
        return sharedValue;
    }
    public Lock getLock(){
        return lock;
    }
}