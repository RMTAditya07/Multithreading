# MUTEX (Mutual Exclusion)

- A mutex is a synchronization mechanism that serves as a lock to ensure mutual exclusion.
- Mutex is a specific kind of binary semaphore that is used to provide a locking mechanism. 
- Mutex is mainly used to provide mutual exclusion to a specific portion of the code so that the process can execute and work with a particular section of the code at a particular time. 


## Properties of a Mutex Lock in Java

1. Mutual Exclusion : Only one thread can acquire the mutex lock at a time, preventing concurrent access to shared resources.
2. Ownership : The thread that acquires the mutex lock is the only one that can release it, ensuring proper resource management.
3. Blocking : If a thread attempts to acquire the locked mutex, it will be blocked until the lock is released by the owning thread.
4. Non-busy Waiting :  Threads waiting for the mutex are not actively spinning in a loop but are put in a waiting state until mutex is available.

## Advantages of Mutex
- No race condition arises, as only one process is in the critical section at a time.
- Data remains consistent and it helps in maintaining integrity.
- It’s a simple locking mechanism that can be obtained by a process before entering into a critical section and released while leaving the critical section.


## Disadvantages of Mutex
- If after entering into the critical section, the thread sleeps or gets preempted by a high-priority process, no other thread can enter into the critical section. This can lead to starvation.
- When the previous thread leaves the critical section, then only other processes can enter into it, there is no other mechanism to lock or unlock the critical section.
- Implementation of mutex can lead to busy waiting that leads to the wastage of the CPU cycle.