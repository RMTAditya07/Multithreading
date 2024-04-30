package Semaphore.WithSynchronization;

import java.util.concurrent.Semaphore;

public class Concurrency {
    public String printNumbersInOrder() throws InterruptedException {
        StringBuilder output = new StringBuilder();

        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);
        Semaphore semaphore3 = new Semaphore(0);
        Semaphore semaphore4 = new Semaphore(0);

        Thread t1 = new Thread(new NumberOneThread(semaphore1, semaphore2, output));
        Thread t2 = new Thread(new NumberTwoThread(semaphore2, semaphore3, output));
        Thread t3 = new Thread(new NumberThreeThread(semaphore3, semaphore4, output));
        Thread t4 = new Thread(new NumberFourThread(semaphore4, output));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        return output.toString();
    }
}
