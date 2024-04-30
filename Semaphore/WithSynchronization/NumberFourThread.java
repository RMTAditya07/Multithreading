package Semaphore.WithSynchronization;

import java.util.concurrent.Semaphore;

public class NumberFourThread implements Runnable {

    private final Semaphore semaphore1;
    private final StringBuilder output;

    public NumberFourThread(Semaphore semaphore1, StringBuilder output) {
        this.semaphore1 = semaphore1;
        this.output = output;
    }

    @Override
    public void run() {
        try {
            semaphore1.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        output.append("4");
    }
}