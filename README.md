# Multi Threading

- Multithreading is a powerful concept in java, allowing you to run mulitple threads of execution concurrently.
- Multithreading is the ability of a program or an operating system to enable more than one user at a time without requiring multiple copies of the program running on the computer.



## The Need for Syncronization

Imagine you have a bank account with a balance of $100, and two threads are running concurrently.
One is trying to withdraw money, and the other is attempting to deposit money.

1. Thread A (withdraw) reads the current balance, which is $100.
2. Thread B (deposit) also reads the same current balance, which is still `$100`.
3. Thread A calculates the new balance after withdrawing `$50`, resulting in `$50`.
4. Thread B calculates the new balance after depositing `$30`, resulting in `$130`.
5. Thread A updates the balance to $50.
6. Thread B updates the balance to $130.

In this scenerio, both threads are not synchronized, and they read and modify the balance concurrency.
As a result, the final balance is `$130`, even though the expected behavior should be a balance of `$80` (`$100 - $50 + $30`)


### Three Reasons for Synchronization Issues

#### 1. Critical Section

- A Critical section in multithreading refers to a section of code or a block of code where multiple threads may access shared resources or data concurrently.
- To ensure correct and consistent behavior, only one thread should be allowed to execute the critical section at a time while other threads wait their turn.
- This synchronization is achieved using technique like locks, mutexes (mutual exclusion), or semaphores.

#### 2. Race conditions

A race condition can be described as a situation where more than one thread attempts to enter a critical section (a section of code where shared resources are accessed) at the same time, leading to unpredictable and incorrect behavior.

#### 3. Preemptiveness

Preemptive multitasking as the name suggests "Pre-Emptying", allows the operating system to interupt a thread and give control to another.

```Synchronization problem occurs only when all the above three conditions are met. To resolve synchronization issues, we need to address any one condition amongst the three```