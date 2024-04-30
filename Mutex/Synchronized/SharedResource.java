package Synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private int sharedValue = 0;

    private Lock lock = new ReentrantLock();

    public void add(int value){
        lock.lock();
        try{
            sharedValue += value;
        }
        finally {
            lock.unlock();
        }
    }

    public void subtract(int value) {
        lock.lock();
        try{
            sharedValue -= value;
        }
        finally {
            lock.unlock();
        }
    }
    public int getSharedValue() {
        return sharedValue;
    }

    public Lock getLock() {
        return lock;
    }
}


// By acquiring and releasing the lock using lock.lock() and lock.unlock() respectively, 
// we ensure that only one thread can execute the critical sections of the add and subtract 
// methods at any given time, preventing concurrent interference and ensuring consistent and 
// correct results.

// With these modifications, the code becomes synchronized, and the final share value will
//  always be 0, as expected, regardless of how many times you run the program