package Semaphore.WithoutSynchronization;

public class Concurrency {
    public String printNumbersInOrder() throws InterruptedException {
        StringBuilder output = new StringBuilder();

        Thread t1 = new Thread(new NumberOneThread(output));
        Thread t2 = new Thread(new NumberTwoThread(output));
        Thread t3 = new Thread(new NumberThreeThread(output));
        Thread t4 = new Thread(new NumberFourThread(output));

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
