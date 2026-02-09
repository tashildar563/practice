### How does the thread pool manage the number of threds in the pool?
* a thread pool manages threads based on three things
  * core pool size
  * maximum pool size
  * work queue

* when you submit task
* if fewer thread than corePoolSize --> create new thread immediately, even if idle threads exists, java prefer to grow up to the core size.
* if core threads are full --> put the task into the queue --> no new thread yet.
* if queue is full --> try to create new thread upto maxumumPoolSize
* if queue is full and max thread reached --> reject the task --> this triggers rejection policy

### what are the benefits of using thread pool?
* reuses threads instead of creting distroyinhg them repeatedly
* reduces thread creation overhead and imporves perfromance
* controls the number of concurrent threads
* prevent system resources exhaustion
* improves applicatoin scalability under load
* provides task queing and scheduiling
* simplifies concurrency management
* enables better cpu utilisation
* support advanced features (timeouts, rejection policies, monitoring)

### what is a single thread executor?
* a single thread executor is an ExcecutorService that manages exactly only </br> worker thread to execute submitted task. all are placed in a queue and are executed sequentially. ensuring that no two task run at the same time. this makes it usefull when you need  ordered execution or want to avoid </br> sunchronisation issue by preventing concurrent access to shared resources. if the single thread fails due to an exception, the executor automatically creates a new one to continue processing tasks.

### explain the life cyle of an ExecutorServices ?
* creation :
  * executor is created using executors factory method or ThreadPoolExecutor
  * no threads are created immediately
  * threads are created when task are submitted.
* Running
  * task are submitted using submit() or execute().
  * threads pick tasks from the queue and execute them
  * new task are accepted
* shutdown initiated
  * trigger by calling shutdownI()
  * executor stops accepting new tasks
  * already submitted tasks continue to execute
  * executor enters SHUTDOWN state
* Graceful termination
  * executor completes all queued and runnign tasks
  * threads become idle and terminate
  * isShutdown() returns true.
  * isTerminated() returns true once finshed.
