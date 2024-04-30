package Synchronized;


public class Adder extends Thread {
    private SharedResource resource;

    public Adder(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 5000; i++) {
            resource.add(i);
        }
    }
}
