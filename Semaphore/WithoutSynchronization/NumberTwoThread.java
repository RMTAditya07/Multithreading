package Semaphore.WithoutSynchronization;

public class NumberTwoThread implements Runnable {
    private final StringBuilder output;

    public NumberTwoThread(StringBuilder output) {
        this.output = output;
    }

    @Override
    public void run() {
        output.append("2");
    }
}
