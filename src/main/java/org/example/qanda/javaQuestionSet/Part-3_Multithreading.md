### 1. How do you create a thread in java?
* Create thread in java by either
  * Extending the `Thread` class : create a subclass of thread and override the run() method to define the task.
  * Implementing the `Runnable` interface: create a class tha implements Runnable and devine run() method. then pass an instance of 
  the class to a Thread object and start the thread by calling its start() method.

### 2. Different States of a thread in java?
* ***New*** : a Thread is in state when it is created but not started.
* ***Runnable*** : a thread is in this state when it is ready to execute, but the JVM scheduler decides when to run it.
* ***Blocked*** : a thread enters this state when it is waiting for a lock to be released by another thread.
* ***Waiting*** : a thread enters this state when it is waiting indefinitely for another thread to perform a particular action.
* ***Timed waiting*** : a thread enters this state when it is waiting for specific amount of time.
* ***Terminated*** : a thread enters this state when it has finished execution or was terminated due to an error.

### 3. Runnable vs Thread
* `Runnable` is an interface that defines single method run(), which contains
the code to be executed by a thread.
  * Job description (what work need be done).
* `Thread`, on the other hand, is a class that represents an actual thread of 
execution. 
  * the thread is created in two ways either by exteding the Thread class 
  or by implementing the runnable interface.
  * Worker (who performs the job).
  * when thread is created extending the Thread class, Thread and task is tightly coupled.
  * but when the thread is implemented Runnable interface, Thread and task is not tightly coupled.
  improving the reusability
### 4. Purpose of Start() method in the Thread class?
* start() method used to initiate the execution of a thread.
* it causes the thread to transition from `New` state to the `Runnable`state.
* The actual execution of the thread happens when the JVM scheduler selects it to run.
* The start() method internally calls the run() method, where threads task is defined.

### 5 What is synchronisation in java?
* it is mechanism in java that ensures that multiple threads do not access shared
resources concurrently, which could lead to inconsistent states or race condition.
* By using syncronisation only one thread can access a resources at a time, maintaining thread safety.

### 6. what is Deadlock?
* deadlock is situation where two or more threads are blocked forever, each waiting for resource that the other holds.

### 7. different ways to achieve thread synchronisation in java?
* **Syncronised Methods** : locking entire method so that only one thread can execute it at a time.
* **Syncronised Blocks**: locking specific blcok of code within method providing more granular control over which sections of code are syncronised.
* **Explicit locks** : using ReentrantLock and other locks from the `java.util.concurrent.locks` package for more advanced synchronisation features, such as trying to acquire a lock without blocking.

### 8. What are the ways to achieve thread safety in java?
* **Synchronisation**: using Synchronisation block or methods to control access to shared resources.
* **Volatile Variables**: Ensuring that changes to variable are immediately visible to other threads.
* **Atomic variables**: Using Classes like `AtomicInteger` or `AtomicReference` to perform operations automatically.
* **Concurrent Collections**: Using thread safe collection like ConcurrentHashMap or CopyOnWriteArrayList of managing shared data.

---
### 9. Code:

```java
class Resource {
    public synchronized void test1() {
        System.out.println("Inside Test1 Method");
        try {
            Thread.sleep(Long.MAX_VALUE);;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static synchronized void test2() {
        System.out.println("Inside Test2 Method");
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Task1 implements Runnable {
    private Resource resource;
    public Task1(Resource resource) { this.resource = resource; }
    @Override
    public void run() {
        resource.test1();
        resource.test2();
        System.out.println("Invoked Test2 Method from Task1");
    }
}
class Task2 implements Runnable {
    private Resource resource;
    public Task2(Resource resource) { this.resource = resource; }
    @Override
    public void run() {
        resource.test2();
        resource.test1();
        System.out.println("Invoked Test1 Method from Task2");
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        Resource resource =  new Resource();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Thread t1 = new Thread(new Task1(resource));
        Thread t2 = new Thread(new Task2(resource));
        t1.start();
        t2.start();
    }
} 
 
```
* observation : 
* You have two types of synchronized methods:
  * ```java 
    public synchronized void test1();
    ```
    * This is an instance-level lock. 
    * Lock monitor = resource instance. 
  * ```java 
    public static synchronized void test2();
    ```
    * This is a class-level lock. 
    * Lock monitor = Resource.class 
  * These two locks are completely different.
  * An instance lock never blocks a class lock and vice-versa.
* Why no deadlock occurs
  * test1() locks -> resource (instance lock)
    * acquires instance lock
    * enters test1();
    * Sleeps forever
  * test2() locks -> Resource.class (class lock)
    * Acquires class lock (Resources.class)
    * enters test2()
    * sleep forever
  * no deadlock
  * both threads block forever inside their first sleep
  * neither thread reaches the second method call or prints the final msg.
  * output will be\
    `inside Test1 Method`\
    `inside Test2 Method`
---

### What are the different types of threads in java?
* User thread
  * threads which are created by developers for example Main thread.
* Demon Thread
  * it is low priority thread that runs in the background to perform task such as garbage collection
### When to use volatile variable in Java?
* the volatile keyword in java is used to ensure visibility of changes to a variable across multiple threads, but it does not guarantee atomicity.
you should use a volatile variable in scenario where multiple threads access a shared variable.
* common use case
  * flags for thread control
  * status indicator : variable that represents the state of an application which are updated by one thread and read by many.
  * double-checked locking : 
  * one writer many readers scenarios : when single thread is responsible for updating a shared variable and multiple other threads only read it.

