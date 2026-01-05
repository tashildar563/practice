### what is Spring boot ? why did we use spring boot in project and why not spring?
* spring boot is a spring module
* elaborating - spring boot is a framework for RAD build using spring framework with extra support of autoconfiguration
and embedded application server(like tomcat, jetty).
* it provides RAD 
* it helps us in creating efficient fast stand alone applications which you can just run it basically removes a lot of configuration and dependencies.

### What RAD that you are talking about how can you achieve RAD using spring boot?
* RAD is modified waterfall model which focuses on developing software in a short span of time.
* Phases of RAD are as follows 
  * Business model :
  * data modeling : data model is designed the relation between these idea objects are eastablished using info gathered in first phase.
  * process modeling : CRUD operations 
  * application generation : the actual product is built using coding convert process and data modeling into actual prototypes.
  * testing and turnover : product is tested and if changes are required when whole process start again.
### how to desable a specific auto-configuration class?
* you can use the exclude attribute of @EnableAutoConfiguration, if you find any specific auto-configuration classes that you do not want are being applied.
* By using "exclude"
* @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

### what does the @SpringBootApplication annotation do internally?
* as per the spring boot doc, the @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes
,spring boot enables the developer to use a single annotation instead of using multiple. but as we know, spring provided loosely coupled features that we can use for each individual annotation as per our project needs.

### Explain @RestController annotation in spring boot?
* @RestController is a convenience annotation for creating restful controllers. it is a specialisation of @Component and is autodetected through classpath scanning. it adds the @Controller and @ResponseBody annotations. it converts the reponse to JSON or XML
* which eliminates teh need to annotate every request handling method of the controller class with the @ResponseBody annotation. it is typically used in combination with annotated handler method based on the @requestMapping annotation.
* indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
