### What we can do reduce or improve the API latency?
* Use caching
  * in memory chashing >> `Redis cache client`,`Guava`
  * distributed cashing >> `Redis`, `Memcached`
  * HTTP response cashing
  * data base query cashing
  * CDN cashing for static content
* optimise database calls
  * use proper queries
  * reduce joins where possible
  * user pagination instead of returning big lists
  * use connection pooling
* Reduce payload size >> large JSON slow api
* Use asynchronous processing
* Connection pooling
* use load balancing
* horizontal scaling >>> add more service instances

### Connection pooling
* Connection pooling is a technique used to reuse database connection instead of creating a new one for every request.
* in spring boot connection pooling is enabled by default and handled by HikariCP
* How connection pooling works
  * Application starts and HikariCP creates a pool DB connection
  * API request comes in > HIkariCP gives an available DB connection 
  * after the transaction the connection is returned to pool, it becomes available for the next request.
  * if all connection are busy >> new request waits for a connection if timeout expires -> spring throws exception
### How will you expose the APIs to external customers?


### what are the things to do while deploying infrastructure and code in large distributed application
* first all infrastructure is provisioned using IaC tools like terraform or CloudFormation so environment 
stay consistent. before any release, i validate environment configs, secrets, network rules and dependencies 
such as databases cashes queues and external service.
* then i use CI/CD pipeline that runs automated test, security scans and promotes builds through dev, QA, 
staging, and production. for production deployments 
i prefer safe strategies like rolling updates, blue-green or canary deployements to avoid downtime and make rollbakc easier.
* i handle database changes carefully using backword compatible migrations and version tools like 
liquibase or flyway. observability is also critical i ensures logs metrics dashboard and distributed tracing are in place so we can monitor error rates, latency and system health in real time.
* additionally, i validate autoscaling rules, health checks and graceful shutdown to ensure smooth traffic handling after deployment i run smoke test or synthetic
check to verify end to end functionality
* overall my focus is on automation safety observability and having clear rollback strategy for reliable deployements.


### SAGA
* the saga design pattern manages distributed transaction across microservices by breaking them into
a sequence of local, ACID-compliant transactions, each triggering the next via events.
* types of SAGA:
  * choreography : each service publishes events, other services subscribe and react no central coordincator.
  * Orchestration : A central service manages the flow, telling each participant service when to do.