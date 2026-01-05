### RESTApi vs Websocket
| feature             | RESTApi                                                                               | Websocket                                                                                                   |
|:--------------------|:--------------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------------|
| Communication Model | Client initiated request response (Unidirectional)                                    | Full duplex, both client and server can send msg                                                            |
| Connection type     | Stateless :each request require new HTTP connection                                   | Stateful : a single, persistent TCP connection is established and kept open                                 |
| Protocol            | HTTP/HTTPS                                                                            | A different  porotocol that startw with an HTTP handshake and then upgrades to a ws:// or wss:// connection |
| latency & overhead  | Higher latency due to the overhead of new headers and handshake for each request      | lower latency and minimal overhead after the  initial handshake                                             |
| Scalability         | Generally easier to scale horizontally by adding more serves behind a load balancer   | More complex to scale due to the need to manage many persistent stateful connection                         |

### kafka vs Rabitmq