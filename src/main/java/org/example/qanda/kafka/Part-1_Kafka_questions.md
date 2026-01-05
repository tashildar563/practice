### Kafka Architecture
![img.png](img.png)


### Pub Sub System
* in pub sub system producers publish messages to topics and consumers subscribe to those topics to receives the messages.

### Stream Processing Pipelines
* stream processing piplines involve contiuously ingesting, processing and transforming data in real time.

### Log Aggregation Architectures
* log aggregation involves collection log data from various sources, centralising it and making it available for analysis.
kafka's durability and scalability make it an excellent choice for log aggregation systems.

### Core Component of Kafka arhitecture
* ***kafka Cluster*** : a distributed system of multiple kafka brokers that ensures 
fault tolerance, scalability and high availability for real time data streaming.
* ***Brokers*** : Kafka servers that handle data storage and read write operations and manage data replication for reliability.
* ***Topic & Partitions*** :  Data is organised into topics(logical channels), divided into partitions for parallelism and horizontal scalability.
* ***Producers*** : Client Applications that wrtie data to kafka topics, distributing records across partitions.
* ***Consumers*** : application that read data from topics; consumer groups enable load balancing and fault tolerence.
* ***Zookeeper*** : Manages and coordinates kafka brokers, handling configuration, synchronisation and leader election.
* ***Offsets*** : Unique ids for each messages in a partition, used by consumers to track read progress.

### 