package Semaphore.WithSynchronization;

import java.util.concurrent.Semaphore;

public class NumberOneThread implements Runnable {

    private final Semaphore semaphore1;
    private final Semaphore semaphore2;
    private final StringBuilder output;

    public NumberOneThread(Semaphore semaphore1, Semaphore semaphore2,StringBuilder output) {
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
        this.output = output;
    }

    @Override
    public void run() {
        try{
            semaphore1.acquire();
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        output.append("1");
        semaphore2.release();
    }
}