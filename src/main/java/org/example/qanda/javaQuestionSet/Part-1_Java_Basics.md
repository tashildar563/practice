### - 1 What is Java?

java is a object-oriented programming language and platform, known for its
"write once, run anywhere" ability via the JVM.
used to build everything from mobile apps and web application to enterprise software.

### - 2 Explain the difference between JDK, JRE, JVM

| Aspect                  | JDK                                       | JRE                                    | JVM                                                     |
|:------------------------|:------------------------------------------|:---------------------------------------|:--------------------------------------------------------|
| **purpose**             | used to develope java applications        | used to run java applications          | executes java bytecode                                  |
| **Platform dependency** | platform dependent                        | platform dependent                     | JVM is OS specific but bytecode is platform independent |
| **includes**            | JRE + developement kit (javac, debugger)  | JVM + Libraries                        | classloader, jit compiler, garbage collector            |
| **use case**            | Writing and compiling java code           | Running a java application on a system | convert bytecode into native machine code               |

### 3 what are the main principles of object oriented programming (oop) in java?
* **Classes and objects**
   * **class** : a blueprint or template for creating objects. it defines the properties and behaviors.
   * **object** : an instance of a class. it is a real world entity with a state and behavior.
* Encapsulation
  * bundles data and methods into single unit and restricts direct access of the objects components.
  * Encapsulation means protecting data by not allowing outside code to access it directly. Instead, access is given through controlled methods
* Inheritance
  * a mechanism where a new class can inherit properties and behaviours from an existing class.
  * this promotes code reusability and establishes a is -a relationship between classes.
* Polymorphism:
  * meaning many forms. it allows objects of different classes to be treated as object of a common type.
    * Method overloading (compile): same name but different params
    * method overriding (runtime): a subclass providing a specific implementation for a method already defined in its superclass
  * abstraction
    * the process of showing only the essential features of an entity and hiding the complex implementation details.
    * in java abstraction is achieved using abstract classes and interface, which defines a contact for what an object should do, without specifying how it does it.

### 4 what are access modifiers in java?
* in java access modifiers are keywords used to set the visibility and accessibility of classes.\
methods, contractors, and variables. they control who can access what in program. java has four access modifiers 
  * public - accessible from anywhere in the program
  * private - accessible only within the same class
  * protected - within the same packages.
  * default - only within the same packages not accessible from outside the package.

### 5 what is a constructor/ how is it different from a method?
* a constructo in java is a special block of coe used to initialise objects. it runs automatically when an object is created using new keywork.
  * a constuctor
    * has the same name as the class
    * does not have a return type (not even void)
    
| Constructor                                   | method                            |
|:----------------------------------------------|:----------------------------------|
| Must be same as class name                    | can be any valid name             |
| no return type                                | must have return type             |
| called automatically when an object is crated | called manually using the object. |
| to initialise object values                   | to perform actions/operations     |

### 6 Explain method overloading and method overriding with examples.
* Method overloading - Compile time polymorphism
  * method overloading occurs when multiple methods in the same class have the same name but different parameters
    * happens withing same class
    * decided at compile time
* Method overriding (Runtime polymorphism)
  * method overriding happens when a subclass provides its own version of a method that is already defined in the parent class
    * must have same method name, same parameters, and same return type.
    * happens in different classes (parent child relationship)
    * decided at runtime
    * requires inheritance

### 7 what is an abstract class and interface? what are their differences?
* ***Abstract*** class is a class that cannot be instantiated and may contain abstract methods as well as regular methods.
  * declared using **abstract** keyword.
  * can have constructors.
  * can have variables, including non final ones
  * used when we want partial abstraction and shared functionality.
* ***Interface*** is fully abstract blueprint of a class.
  * only contains abstract methods before java-8 but can also have
    * default methods
    * static methods 
    * private methods (java 9+)
  * Key points ;
    * declared using interface keyword
    * cannot have constructors
    * all variables are public static final by default
    * supports multiple inheritance.
    * used to define capabilities or behavior.

### 8 What is exception handling in Java?
* an exception is an event that occurs during program execution and distrusts the normal flow of instructions
  * Exception handling
    * `try` contains code that might throw an exception.
    * `catch` used to handle the specific exception thrown in the try block
    * `finally` always executes, and used when there are action to be performed after exception is thrown.
    * `throw` used to explicitly thrown an exception.
    * `throws` placed in method signature to declare exceptions that the method might throw.
  * Types of Exceptions
    * Checked Exception
      * checked at compile time
        * IOException, SQLException, FileNotFoundException
    * Unchecked Exception
      * Checked at runtime.
        * ArithmeticException, Null pointer exception, ArrayIndexOutOfBondException
  * prevents program from crashing
  * separate error-handling code from normal code
  * provides meaningful messages to users.
  * Helps maintain smooth program flow.
### 9 How does garbage collection work in Java?
* GC is process of identifying objects that are no longer reachable, automatically freeing the memory they occupy, prevent memory leaks
* JVM automatically performs GC in the background.
* How does GC determine an object is garbage
  * no variable references it
  * it is part of an island of objects that are no longer reachable.
### 10 Runtime Data Areas (Memory model)
* JVM divides memory into
  * Heap (shared)
    * stores all objects
    * shared across threads
    * garbage collected
  * Stack(per-thread)
    * stores local variables
    * method call frames
    * primitive values and references
  * Metaspace
    * stores class metadata
    * static fields
    * method bytecode
  * PC Register
    * current instruction of each thread
  * Native method stack
    * support native code via JNI

### 11 volatile keyword
* using volatile is yet another way of making class thread safe. thread-safe means that a method or class instance can be used by multiple threads at the same time without any problem.
* the volatile keyword is a modifier that ensures that an attribute's value is always the same when read from all threads.
* the volatile keyword makes sure that threads always update the value of an attribute in main memory.

### java8 vs java17
| Java 8                                 | Java 17                        |
|:---------------------------------------|:-------------------------------|
| Lamdas and functional interface        | Records immutable data classes |
| Streams API                            |                                |
| Default and static method in interface |                                |
| Optinal Class                          |                                |
| Date & time API (java time)            |                                |

### Access Modifiers
| Access Modifier | Inside Class | Inside Package | Outside package (Subclass) | outside package (Non-subclass) |
|:----------------|:-------------|:---------------|:---------------------------|:-------------------------------|
| private         | yes          | No             | No                         | No                             |
| default         | Yes          | Yes            | No                         | No                             |
| protected       | yes          | yes            | yes                        | no                             |
| public          | yes          | yes            | yes                        | yes                            |

### How String stored in Memory
* In Contiguous memory locations
* in java it is stored in head 

### What is the difference between Serializable and Externalizable in Java?
* core difference between serializable and externalizable in java is that seriablisable uses default seriablisation where the runtime automatically handles object persistance
while externalisable requires explicit control through custom read/write methods.

| feature     | serializable              | externalizable                                    |
|:------------|:--------------------------|:--------------------------------------------------|
| methods     | none (Marker interface)   | writeExternal, readExternal (must be implemented) |
| control     | Limited (automic process) | full (developer control process)                  |
| Ease of use | High (very easy)          | requires custom implementation                    |
| Security    | exposes private data      | only explicit data saved                          |




