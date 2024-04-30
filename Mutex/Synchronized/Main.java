
package Synchronized;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Adder adder = new Adder(resource);
        Subtractor subtractor = new Subtractor(resource);

        adder.start();
        subtractor.start();

        adder.join();
        subtractor.join();

        System.out.println("Final Share Value (Synchronized) : " + resource.getSharedValue());
    }
}

// In this code
// 1. SharedResource is class that contains the shared value
// 2. Adder and Subtractor are two separate threads that increment and decrement the shared value respectively
// 3. The Main class creates instances of Adder and Subtractor, starts them concurrently, and then waits for them to finish using join().

// When the code is executed, its observed that the final shared value is not always 0, which indicates a synchronization issue because the add and subtract operations are not synchronized.

// Without any synchronization mechanism, both Adder and Subtractor threads run concurrently and can access the shared resource simultanously
// This can lead to race conditions, where the order of execution and interleaving of operations between the threads are unpredictable.
// As a result, the final value of the shared resource can vary each time the program is run.