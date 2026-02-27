### RESTApi vs Websocket
| feature             | RESTApi                                                                               | Websocket                                                                                                 |
|:--------------------|:--------------------------------------------------------------------------------------|:----------------------------------------------------------------------------------------------------------|
| Communication Model | Client initiated request response (Unidirectional)                                    | Full duplex, both client and server can send msg                                                          |
| Connection type     | Stateless :each request require new HTTP connection                                   | Stateful : a single, persistent TCP connection is established and kept open                               |
| Protocol            | HTTP/HTTPS                                                                            | A different  protocol that start with an HTTP handshake and then upgrades to a ws:// or wss:// connection |
| latency & overhead  | Higher latency due to the overhead of new headers and handshake for each request      | lower latency and minimal overhead after the  initial handshake                                           |
| Scalability         | Generally easier to scale horizontally by adding more serves behind a load balancer   | More complex to scale due to the need to manage many persistent stateful connection                       |

### REST vs SOAP
| SOAP                                                           | REST                                                                                                                                                    |
|:---------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------|
| Relies on Simple object access protocol                        | relies on REST (representational state transfer) arhitecture using HTTP                                                                                 |
| Transports data in standard XML format                         | Generally transports data in JSON. it is based on URI. because REST follows a stateless model, rest does not enforce message formats as XML or JSON etc |
| because it is xml based and relies on SOAP, it works with WSDL | it works with GETm POST, PUT, DELETE                                                                                                                    |
| works over HTTP, HTTPS, SMTP. XMPP                             | works over http and https                                                                                                                               |
| higly structured/typed                                         | less structured / less bulky data                                                                                                                       |
| designed with large entrprice applications in  mind            | designed with mobile devices in mind                                                                                                                    |
|                                                                |                                                                                                                                                         |

### put vs post vs patch
| post                                                                   | put                                                                              | patch                                                        |
|:-----------------------------------------------------------------------|:---------------------------------------------------------------------------------|:-------------------------------------------------------------|
| create a new resouce                                                   | replace an entire resouces or create if it doesnt exist at know uri              | apply partial modification to an existing resource           |
| send data to a collection URI the server genrates the new resource uri | requires the client to send the complete resouce representaion to a specific uri | requries sending only the specific fields that need updating |
| not idempotent                                                         | idempotent                                                                       | not necesarily idempotent                                    |