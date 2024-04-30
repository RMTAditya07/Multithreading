package Synchronized;

public class Subtractor extends Thread{
    private SharedResource resource;

    public Subtractor(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 5000; i++) {
            resource.subtract(i);
        }
    }
}
