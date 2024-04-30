# Semaphore

Semaphores are a synchronization construct used to manage access to shared resources and coordinate the execution of multiple threads in a concurrent environment.

They maintain an internal count, and threads can request access by acquiring permits from the semaphore. If permits are available, the thread is granted access; otherwisel it blocks until the permits become available. 

When a thread finishes using the resource, it releases the permits, making them available to other waiting threads.

Semaphores can be used to enforce access limits, protect critical sections of code, and establish synchronization points between threads.

### The Dance of Threads

To explain the concept and importance of Semaphore, let's take an example.

We have four threads with unique roles: 
    1. NumberOneThread
    2. NumberTwoThread
    3. NumberThreeThread
    4. NumberFourThread
   
Their task is to add their assigned numbers in the sequence from 1 to 4.
The Twist is, these threads are like independent dancers, each following their own steps without knowing what the others are doing.
When they start their routinesm there's no one to coordinate their moves. 
Without synchronization, they dance freelym leading to an unpredictable show. 
In one run, we might see "1234", while in another, it could be "3214" or any other order.


### Creating a Semaphore

In java, you can create a semaphore using the `java.util.concurrent.Semaphore` class. 
To create a semaphore, you typically use one of its constructors, specifying the initial number of permits available.

```
import java.util.concurrent.Semaphore;

public class MySemaphoreClass{
    Semaphore semaphore = new Semaphore(initialPermits);
}
```

The `initialPermits` parameter represents the initial number of permits available in the semaphore.

It determines how many permits can initially access the protected resource or critical section without blocking.

For example, if you set `initialPermits` to 1, only one thread can acquire the semaphore initially without blocking.

The `java.util.concurrent.Semaphore` class provides essential methods for managing semaphores in a multi-threaded environment

- `acquire()` : Request and acquire permits from the semaphore, blocking the thread if none are available.
- `release()` : Release permits back to the semaphore, allowing other threads to acquire them.
- `tryAcquire()` : A non-blocking alternative to `acquire()`; returns  `true` if permits are acquired and `false` otherwise.
- `availablePermits()` : Query the number of available permits.
- tryAcquire(int permits) : Request multiple permits at once, returning `true` if all permits are acquired.
- `release(int permits)` : Release a specified number of permits.


### Coordinating the Dance with Semaphores

- To maintain order, we'll use semaphores to signal when a thread is allowed to run.
- For example, we'll employ semaphores to guarentee that `NumberOneThread` gets the first chance to perform its part of the dance, followed by `NumberTwoThread` and so on.
- All the classes now incorporates two semaphores: Semaphore1 and Semaphore2.
- These semaphores control the sequence of execution for the threads.
- `Semaphore1` acts as a gatekeeper, allowing a thread to proceed only when the stage is clear.
- `Semaphore2` is release by a thread to signal the next thread in line to take the stage.
- Notably, the `NumberFourThread` requires only `Semaphore1` because it is the final performer, and there are no more threads after it. This streamlined synchronization approach ensures that the `NumberFourThread` executes its part of the dance with the appropriate semaphore control.

In these thread classes, the `run()` method follows a general pattern:

1. Thread acquires `semaphore1`, which means it waits for permission to begin its execution. If permission is not available, the thread enters a waiting state.
2. After obtaining permission, the thread performs its specific action.
3. It appends a character corresponding to its role to the shared `StringBuilder`, contributing to the final synchronized sequence.
4. Once its task is complete, the thread releases `semaphore2`. This operation signals the next thread in line to start its execution.

To orchestrate the synchronized dance of our four threads and ensure they perform in a coordinated manner, modifications to the `Concurrency` class too. This modification allowed us to control the order of execution and achieved the desired synchronized output.

`Semaphore1` is initialized to 1 permits while the others (`semaphore2`, `semaphore3`, `semaphore4`) are set to 0 permits.

`semaphore1` plays a unique role in out synchronized dance performance. It is initialized to 1, symbolizing its position as the leader of the troupe. This configuration ensures that the first thread to execute will always be `NumberOneThread`.

- At the start of the performance, the first thread, NumberOneThread, acquires semaphore1. This allows it to take the lead and start the synchronized sequence.
- In contrast, semaphore2, semaphore3, and semaphore4 are initialized to 0. This means they require a signal from the preceding thread to be allowed to start their respective actions.
- NumberOneThread releases semaphore2 after its execution, allowing NumberTwoThread to acquire it and start its performance.
- NumberTwoThread releases semaphore3, permitting NumberThreeThread to acquire it and join the synchronized dance.
- NumberThreeThread releases semaphore4, signaling to NumberFourThread that it's time for the final act.