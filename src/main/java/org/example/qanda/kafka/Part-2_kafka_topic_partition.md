### Why are topics partitioned in Kafka?
primarily for scalability, parallelism and fault tolerance.

### what is partition leader and follower in kafka?
in kafka each partition has one leader that handles all client read/write requests, ensuring data 
consistency and single point fo contact for the partition other replicas for that partition act as followers, <br/> 
passively copying data from the leader amd keeping it in sync to provide fault tolerance.

### Replication factor
* the number of copies of each topics portions that are 
maintained across different brokers in a cluster providing 
fault tolerance and high availability by preventing data loss if a broker fails.

### How does Kafka achieve Exactly-Once?
by combining idempotent producer and automic transaction that froup message wrties and offset commit together

### how to create idempotence producer 
defining the property `spring.kafka.producer.enable-idempotence=true`