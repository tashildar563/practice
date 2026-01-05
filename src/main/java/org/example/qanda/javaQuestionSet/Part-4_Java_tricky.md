
* 1 
``` java
class Main {

    public static void main(String args[]) {
        System.out.println("public main");
    }

    private static void main(String args[]) {
        System.out.println("private main");
    }
}

```

### What happen whe i run from cli?
* The code will not compile, bcs java does not allow tow method with same signature even if one is public one is private ,
  * method signature does not includes method name, paraneter types 
  * access modifiers are not part of the method signature.


### Explain the Java Memory Model (JMM). How do volatile, synchronized, and final ensure visibility and ordering between threads?
* the java memory model defines how threads interact through memory. it spedifies when a write by one thread becomes visibile to another thread and what execution order is allowed by compiler.
* in java each thread may cache variables locally while main memory is shared. without jmm rules, thread could see stale or incosistent data due to reordering and caching.
* jmm solves this using the concept of happens-before relationships.
  * Happens-before relationship :
    * if A happens-before B, then: all writes in A are visibile to B , operation in A cannot be reordered after B.
  ```java 
    volatile, syncroniszed, final
  ```
    * create happens-before relationship.
* `volatile`
  * ensures visibility, not atomicity.
  * a writes to a volatile variable.
    * is immediately flushed to main memory
    * happens-before every subsequesnt read of that varibale
  * prevent instrusction reordering aroung the volatile variable.
* `syncronozed`
  * ensures visibility + atomicity + ordering
  * when a thread exists a syncronized block;
    * all changes are flushed to main memory.
  * when another thread enters the same lock;
    * it reads the latest values.
  * prevents reordering inside syncronised blocks
* `final`
  * ensures safe publication
  * once a final field is initialised in a constructor
    * other threads see the correctly initialised value
  * prevents reordering between
    * object construction
    * assignment of final fields
    * publishing the object reference


### What is double lock testing in singleton?
Double check locking in a singleton pattern is a techinique to create a single thread safe instance
efficiently in multithreaded apps by checking null twice.
```java
public class Singleton{
  private static volatile Singleton instance;
  private Singleton(){}
  
  public static Singleton getInstance() {
    if (instance == null) {
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }
}
```

### Serialization and transient keyword: 
* The transient keyword is used to mark a variable so that its value is not included during the serialization process.


### Create databases
```http
POST http://localhost:8080/inside\_user/authentication/login//request{"email": "john.doe@example.com","password": "password123"}
response{"id": 2,"email": "john.doe@example.com","token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBleGFtcGxlLmNvbSIsInJvbGVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNzI2OTMxMzE0LCJleHAiOjE3MjY5MzQ5MTR9.p7Y5I7ZLd30zcgaxkfs66WyEgABRW977Ohe8TQKuKZw","type": "Bearer","roles": ["ROLE_ADMIN"]}
```