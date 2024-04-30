package Semaphore.WithoutSynchronization;

public class NumberThreeThread implements Runnable {
    private final StringBuilder output;

    public NumberThreeThread(StringBuilder output) {
        this.output = output;
    }

    @Override
    public void run() {
        output.append("3");
    }
}
