### @Transaction
* annotation in spring boot leverages spring AOP capabilities to manage database transaction declaratively. this mean that
instead of manually writing code to begin, commit  or rollback transactions, you simply annotate methods or classes, and spring handles the transactional
logi
* the internal working
  * AOP proxy creation: when a spring managed bean containing methods annotated with @transactional is created, spring generated a proxy for that bean.
  * this proxy intercepts method call to the annotated method and designate it to a ***TransactionInterceptor*** the
interceptor is responsible for managing the transaction lifecycle.
  * the interceptor check for active transaction and joins the existing transaction else initiate new transaction by acquiring a database connection.
  * method execution the actual business logic within the annotated method is then executed within the context of this transaction.
  * transaction completion:
    * commit : if the method executes successfully without any unchecked exceptions, the interceptor commits the transactions
    * rollback: if unchecked exception occurs during method execution, the interceptor rolls back the transaction, discarding all the changes. checked exception do not trigger a rollback by default
    but this behavior can be configured using rollbackFor and noRollBackFor attributes.
  * resource release: after the transaction is committed or roll back the database connection and other transactional resources are released.
* Propagation : defines how transactions relate when one method calls another:
  * **most common propagation types**:
    * REQUIRED (default) : joins exiting transaction or create new one.
    * REQUIRES_NEW : always start a new transaction, suspend old one.
    * SUPPORTS : use transaction if available: otherwise non-transactional
    * MANDATORY : must already have a transaction or throw exceptions.
    * NEVER : Must not have a transactions throw exception if exists
    * NOT_SUPPORTED : suspend transaction : run non-transactionally.
  * Isolation : 
    * DEFAULT : uses DB default
    * READ_COMMITTED : prevent dirty reads.
    * REPEATABLE_READ : prevents non-repeatable reads.
    * SERIALIZABLE : Highest safety, lowest performance
    * READ_UNCOMMITTED : allows dirty read
  * Rollback : by default rollback on RuntimeException, error but not on checked exception
    * you can override on checked exception
      * `@Transaction(rollbackFor = Exception.class)`\
      `public void process(){}`
    * don't roll back on specific exception:
      * `@Transaction(noRollbackFor = CustomException.class)`\
      `public void process() {}`
### How does Spring-boot Detect beans?
* Spring-boot detects beans automatically using Springs component scanning + configuration processing.
  * When application starts with @SpringBootApplication this annotation includes @ComponentScan @EnableAutoConfiguration @Configuration
  * @ComponentScan tells spring to scan this package and all the subpackages for beans.
  * Spring looks for classes with Component annotations
    * Spring scans all classes for these annotations
      * Bean Producing annotations
        * @Component, @Service, @Repository, @Controller, @RestController, @Configuration
        * if spring finds any of these creates a bean instance and stores it in application context.
  * Spring process @Bean Methods >> every @Bean method returns an object >> spring registers it as a bean.
  * auto-config classes may define extra beans depending on the classpath.
### how to handle global exception in spring boot with example
* In a Spring boot application, global exception handling allows us to manage all 
application errors from a single centralised place instead of handling exceptions 
seperately in every controller or service. this improves readability, consistency and maintainability of REST apis.
spring provides @ControllerAdvices / @RestControllerAdvice to intercept exceptions thrown by controllers and convert them into meaningful HTTP response.

* Core Annotations Explained 
  * @ControllerAdvice
    * works across all controllers and is used for global error handling.
  * @RestContollerAdvice
    * combination of @ControllerAdvice + @ResponseBody
  * ExceptionHandler
    * used to handle specific exception types.
  * ResponseEntity
    * Allows control over HTTP status, headers and response body.
* Example:
  * Custom Exception
    ```java
      public class ResourceNotFoundException extends RuntimeException {  
        public ResourceNotFoundException(String msg){
            super(message);
        }  
      }
      ```
  * Standard Error Response DTO
    ```java
    public class ErrorResponse{
      private String msg;
      private int status;
      private LocalDateTime timestamp;
      // constructors, getters, setters
    }
      ```
  * Global Exception Handler 
    ```java
    @RestControllerAdvice
      public class GlobalExceptionHandler {

      @ExceptionHandler(ResourceNotFoundException.class)
      public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
          ErrorResponse error = new ErrorResponse(
                  ex.getMessage(),
                  HttpStatus.NOT_FOUND.value(),
                  LocalDateTime.now()
          );
          return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
      }

      @ExceptionHandler(Exception.class)
      public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
          ErrorResponse error = new ErrorResponse(
                  "Something went wrong",
                  HttpStatus.INTERNAL_SERVER_ERROR.value(),
                  LocalDateTime.now()
          );
          return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
      } 
    ```
  * Controller Example
      ```java
      @GetMapping("/users/{id}")
      public User getUser(@PathVariable int id) {
          if (id == 0) {
            throw new ResourceNotFoundException("User not found with id " + id);
          }
        return new User(id, "Rakesh");
      }
    ```
    
* Execution flow
  * client calls REST API
  * Controller Throws an exception
  * Spring scans @RestControllerAdvice
  * Matching @ExceptionHandler is executed
  * Client receives Structured JSON error response.

* Handling Validation Errors (Important)
  * For @Valid failures:
  ```java
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) { 
      Map<String, String> errors = new HashMap<>(); 
      ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
      return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
   }
  ```

