package Semaphore.WithoutSynchronization;

public class NumberFourThread implements Runnable {
    private final StringBuilder output;

    public NumberFourThread(StringBuilder output) {
        this.output = output;
    }

    @Override
    public void run() {
        output.append("4");
    }

}
