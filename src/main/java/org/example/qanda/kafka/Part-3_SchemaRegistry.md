### what is schema registry in kafka?
* a central place that stores and manages the structure of your kafka messages

### Why do we need Schema Registry?
* Centralised Schema management : single source of truth
* Data validation & governance : common structure
* schema evolution : management of different versions of schema
* compatibility Enforcement : 
* Decoupling :
* simplified development :

### How does Schema Registry work with producers and consumers?How does Schema Registry work with producers and consumers?
* producer side
  * Writing data
    * Register schema : before sending teh producer checks if it data schema is registered with schema reigstery.
    * if new the registry stores the shcema and return a unique Schema id
    * Serialise and prefix : the producer serialise the data into bytes using the schema and prepends the schema id to the message before sending it to kafka topic
* consumer side 
  * reading data
    * fetch id : the consumer reads the message from the kafka extract the Schema id from the beginining fo the payload
    * retrieve shcema : it use the id and request corresponding shcel fro scheman registrh
    * deserialise : the consumer uses the retrieved shcema to desrialise the binary data back into structured object 

### What are schema compatibility types?
* Backward: new consumers can process data from old producers
* Forward : older consumers can process data from the new producers
* Full : Both backward and forward compatible.
* None : no check performed, allowing any schema change which can easily break producers/consumers

