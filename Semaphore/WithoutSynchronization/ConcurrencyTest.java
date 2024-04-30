package Semaphore.WithoutSynchronization;

public class ConcurrencyTest {
    public static void main(String[] args) throws InterruptedException {
        int repetitions = 50;
        for (int i = 1; i <= repetitions; i++) {
            System.out.println("Test run #" + i);
            testPrintNumbersInOrder();
        }
    }

    private static void testPrintNumbersInOrder() throws InterruptedException {
        Concurrency concurrency = new Concurrency();
        String result = concurrency.printNumbersInOrder();
        if ("1234".equals(result)) {
            System.out.println("Test passed: Numbers printed in order.");
        } else {
            System.out.println("Test failed: Numbers not printed in order.");
        }
    }
}
