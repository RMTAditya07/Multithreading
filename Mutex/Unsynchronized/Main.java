

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Adder adder = new Adder(resource);
        Subtractor subtractor = new Subtractor(resource);

        adder.start();
        subtractor.start();

        adder.join();
        subtractor.join();

        System.out.println("Final Share Value (Unsynchronized) : " + resource.getSharedValue());
    }
}