### why java 8 ? main agenda behind java 8
* to introduce Conciseness in the code.
* java brings in functional programming which is enabled by lambda expression.
* during that time due to python , scala java lost large share of market.

### Advantages 
* compact code
* more readable and reusable code
* more testable code
* parallel operations

### what is lambda expression ?
* lambda expression is an anonymous function (without name, return type and access modifier and having one lambda (->) symbol).

### what are functional interface ?
* functional interface are those interface which have only one abstract method.
* int can have any number of static method, default methods, no restriction on that.
* there are many functional interface already present in java such as eg. Comparable, Runnable

### what is method reference in java 8?
* method reference is replaceent of lambda expression, it is used to refer method of functional interface to an existing method. mainly it is used for code reusability.
* functional interface's abstract method can be mapped to specific existing method using double colon operator(::) this is method reference.
* hence method reference is an alternative to lambda expressions.
* whenever we have existing implementation of abstract method of out functional interface then we can go for method reference. if no such method like testImplementation() is available then go for lambda expressions.

### what are defaults methods ?
* default method is a way for adding new methods to the interface without affecting the implementing classes. hence with this new feature java people defended many compile time errors that my arise due to unimplemented methods of interface.
* us of these default methods is backward compatible.

### is it necessary to override default methods?
* default methods have dummy implementations.
* implementing classes if ok with dummy implementation then use dummy impl of default methods.
* if not satisfied then they can override and provide their own implementation.

### Default is not the access modifier like public or protected or private.
* default was only used in classes till 1.8 version for switch case only but never in interface.

### how default methods in interface cope up with Diamond problem?
* diamond problem of default methods of interface
  * if 2 implemented interface contains same default methods then thats the diamond problem.
* in java, in such situation, the code will not compile.
* Solution to diamond problem.
  * use InterfaceName.super.methodName();

### why static methods were introduced in Java 8;
* reason for introducing static method in interface is that you can call those methods with just interface name, no need to create class and then its object.
* Since interface can never contain:
  * constructors,
  * static blocks
  * nothing costly in terms of memory and performance.
* hence we dont need to create object and hence if you have everything static, then for interface rather than class.


### are static methods available to implementing classes by default?
* static methods are not available to implementing classes.
* they are not default methods, they are static.
* hence you can call these methods using interface name explicitly from implementing classes as implementing classes </br> wont have access to these methods directly.

### what are predicates
* predicates is a predefined functional interface (having only one abstract method)
* the only abstract method of predicate is test(T t);
  * public boolean test(T t);
* whenever we want to check some boolean condition then you can go for Predicates.

### what is predicate joining?
* you can combine prediates in serial predicate.
* threee ways to join :
  * And
  * Or
  * Negate

```java
main(String[] args){
  Prediate<String> checkLength = s->s.length()>=5;
  System.out.println("The length of string is greater than 5 :"+checkLength.test("Hi i am rakesh"));
  Predicate<String> checkEvenLength = s-> s.length()%2==0;
  System.out.println("The length of string is : "+ checkEvenLength.test("hi i am rakesh"));
  
  //it can be joined with and
  System.out.println("after merging with and : "+ checkLength.and(checkEvenLength).test("Hi i am rakesh"));
  
  //it can be joined with or
  System.out.println("After merfing with or : "+ checkLength.or(checkEvenLength).test("Hi i am rakesh"));
  
  //it can be joined with negate
  System.out.println("After merging with negate "+ checkLength.negate().test("hi i am rakesh"));
}
```


### Predicate vs Function
| Predicate                                                                 | Function                                                                                                                         |
|:--------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------|
| it has the return type as boolean, it is used for conditional checks      | it has the return type as object, it is used to perform operations and return result                                             |
| it is written in the form of Predicate<T> which accepts a single argument | it is written in the form of Function<T , R> which is also accepts a single argument but return any type of object Denoted by R. |
| it contains test(T t) method                                              | it contians apply() method.                                                                                                      |

### what are Functions
* Function is also a predefined Functional Interface (Having only 1 abstract method).
* the only abstract method of function is apply(T t);
  * R apply(T t);
* Given some input perform some operation on input and then produce / return result (not necessary a boolean value).
* This takes 1 input and return one output.
* in predicate, we used to take 1 input and return type is always boolean.
* in function return type is not fixed hence we declare both input type and return type.

### what is functional Chaining
* we can combine / chian multiple functions together with andThen.
* there are two ways to combine functions;
  * f1.andThen(f2).apply(Input) - first f1 and then f2.
  * f1.compose(f2).apply(input) - first f2 then f1.
  * mulitple functions can be chained together like:
    * f1.andThen(f2).andThen(f3).apply(input);

### what is functional interface?
* Consumer<T> -> it will consume items and never return anything just consumes it.
* it predefined functionalInterface having accept(T t) a single abstract method.
* we can combine /chain multiple consumers together with andThen.
* there is only one way to combine consumers.
  * c1.andThen(c2).apply(input): first c1 then c2.
  * no compose() in consumer
  * multiple consumer can be chained together like 
    * c1.andThen(c2).andThen(c3).apply(inputs);


### What is a stream pipeline? name its parts and why laziness matters.
1. Source (collection, array, files.lines, generator),
2. Intermediate operations (filter,map,sorted) which are lazy and return a stream and 
3. terminal operation (collect, reduce, forEach) which triggers evaluation. laziness enables fusion and short circuit (limit, anyMatch) for performance.
4. Internal working
   1. java processes elements one at a time
   2. stops as soon as it finds the first match.
   3. does not process the whole list
   ```mermaid
    stateDiagram
   take_one_item --> filter 
   filter --> map
   map --> result
   result --> next
   ```
   
### what is encounter order ? how do forEach and forEachOrdered differ
* what is encounter order : it is the natural order in which a streams source gives elements
* so if the source is ordered, streams try to respect that order unless told otherwise
  * forEach vs forEachOrdered
    1. forEach
        * runs the action on each element
        * on sequential stream -> preserves encounter order.
        * on parallel streams -> may ignore order for performace
    2. forEachOrdered
        * always respects encounter order, even in parallel streams.
        * but slower because it waits and arranges results in the correct order.
       
### what does "non-interference" and statelessness mean? why avoid side effects?
1. Non interference 
    * stream operations must not change the source while the pipeline is running.
    * why? because streams traverse the data once in a predicatable way.
    * if the source changes mid-traversal -> unpredictable result or exceptions
2. Statelessness
   * each element's processing should not depend on external mutable state or on previous elements.
   * the function must behave the same every time for the same input.

### when to use map and flatMap ?
* map() it is used where we have to map the elements of a particular collection to specific function, and then we need to return the stream that contains the updated results.
* flatMap() : it is used where we have to transform or flatten the string, as we cant flatten our string using map().


   