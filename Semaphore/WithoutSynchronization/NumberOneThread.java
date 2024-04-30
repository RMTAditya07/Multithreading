package Semaphore.WithoutSynchronization;

public class NumberOneThread implements Runnable {
    private final StringBuilder output;

    public NumberOneThread(StringBuilder output) {
        this.output = output;
    }

    @Override
    public void run() {
        output.append("1");
    }
}