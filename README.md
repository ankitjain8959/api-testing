# API-Testing
API testing is a process that confirms an API is working as expected.  
It focuses on business logic, response structure, status codes, and data validations rather than UI.  

API Testing can be performed in two main ways:  
1. Manually  
   - Using a postman or cURL  
   - Good for quick checks and exploratory testing  
   - Not ideal for large scale testing or regression testing  
2. Automated; using code  
   - Using API testing frameworks like `RestAssured` (Java-based library used for automating REST API testing) OR Using a BDD approach with `Cucumber` + `RestAssured`  
   - Good for large scale testing, regression testing, and continuous integration  
   - Requires initial setup and maintenance  

  
## API Testing with RestAssured and Cucumber
### What is RestAssured?
RestAssured is a Java-based library that simplifies the process of testing RESTFul APIs and is used for automating REST API testing.

### What is BDD (Behavior-Driven Development)? `Methodology` 
BDD is a software development approach or a methodology that encourages collaboration between developers, testers, and non-technical stakeholders.
It way of writing software tests in plain, human-readable language that anyone (developer, tester, or business person) can understand.

> Think of it like this:  
Instead of writing test code that only developers understand, BDD encourages you to _**describe how the system should behave**_ in a way that both technical and non-technical people can understand and collaborate on.

### What is Cucumber? `Testing Framework or tool`  
It is a testing framework or a tool (most popular ones) that supports BDD (Behavior-Driven Development) practices.  
It uses `Gherkin language` to structure the tests in a way that is easy to read and understand.  
It bridges the gap between non-technical stakeholders and developers by writing scenarios in plain English.    

### What is Gherkin? `Language used by Cucumber`
Gherkin is a domain-specific language used by Cucumber to write test cases. It uses keywords like:  
- Feature
  - Scenario
    - Given (preconditions)
    - When (action performed)
    - Then (expected outcome)
    - And  (for additional steps)

#### Why use RestAssured with Cucumber?
Combining RestAssured with Cucumber allows you to write API tests in a human-readable format while leveraging the powerful features of RestAssured for API interactions.
This approach provides:
- **Documentation**: Gherkin scenarios serve as living documentation for the API.
- **Readability**: Tests are written in plain English, making them accessible to non-technical stakeholders.
- **Collaboration**: Encourages collaboration between developers, testers, and business stakeholders.
- **Maintainability**: Tests can be easily updated as requirements change.
- **Reusability**: Common steps can be reused across multiple scenarios.


## Cucumber and RestAssured Setup
### Prerequisites
- Java Development Kit (JDK) installed
- Maven or Gradle for dependency management
- IDE (like IntelliJ IDEA or Eclipse) for Java development


### Folder Structure for Rest Assured and Cucumber
```
src
├── test
│   └── java
│       └── stepDefinitions       # Java step implementations
│       └── runner                # Test runner class
│       └── utilities             # Reusable classes (like APIUtils, ConfigReader)
├── test
│   └── resources
│       └── features              # .feature files in Gherkin syntax
```


## Hooks in Cucumber
Hooks are special blocks of code that run before or after scenarios or steps.  
Hooks are special `setup` and `teardown` methods that run before or after your scenarios or steps.
  
Types of hooks in Cucumber:  
| Hook Type           | Annotation    | When It Runs                            |
| ------------------- | ------------- | --------------------------------------- |
| **Before** hook     | `@Before`     | Runs **before each scenario**           |
| **After** hook      | `@After`      | Runs **after each scenario**            |
| **BeforeStep** hook | `@BeforeStep` | Runs **before each step** in a scenario |
| **AfterStep** hook  | `@AfterStep`  | Runs **after each step** in a scenario  |



# Integration Testing
Testing the interaction between the components/layers/classes (such as Controllers -> Service -> Repository -> DB).
It tests end-to-end functionality and ensures that different parts of the application work together as expected.
Tools used for integration testing include:
- Spring Boot Test (for testing Spring applications)
- MockMvc (for mocking HTTP requests to your controllers in Spring applications) - tool provided by Spring used to test Spring MVC controllers without starting a real server)
- JUnit 5 (for writing tests in Java)

In Integration testing, we boot up the entire application context, which means we can use dependency injection and test the interactions between different components.

In integration tests, you are not just testing one method — you're testing the interaction between layers:
> Controller ↔ Service ↔ Repository ↔ DB

To do that, Spring must:
1. Create and wire all beans in the right order  
2. Load your configurations (application.yml)  
3. Inject dependencies (e.g., @Autowired)  
4. Connect to database, configure web server (mock or real)


# Unit testing
Testing individual components/class or methods in isolation.
There is no loading of the application context which means, no dependency injection.
Tools used for unit testing include:
- JUnit 5 (for writing tests in Java)
- Mockito (for mocking dependencies)
- AssertJ (for assertions)

# API Testing vs Integration Testing vs Unit Testing
| Criteria          | API Testing                     | Integration Testing                     | Unit Testing                           |
| ----------------- |---------------------------------|-----------------------------------------|----------------------------------------|
| What it tests     | API endpoints                   | Interactions between components         | Individual components or methods       |
| Scope             | Isolated to API                 | Broader system-level                    | Narrow, focused on single class/method |
| Example Component | REST controller                 | Controllers + Service + Repository + DB | Service, Util, Validator classes       |
| Test Focus        | Request/response, validation    | End-to-end data flow                    | Logic in individual classes/methods    |
| Tools             | Postman, REST Assured, Cucumber | Spring Boot Test, JUnit, MockMvc        | JUnit, Mockito, AssertJ                |


### Best Practices
- Use unit tests to test logic in Service, Util, Validator classes.
- Use integration tests for REST controllers, Repositories, and end-to-end functionality.


# Additional Notes on Spring Framework
## Spring (Framework)
- It is a powerful open-source framework (with a large community and ecosystem) for building Java applications, and is widely used for building enterprise-level applications.
- It provides comprehensive `infrastructure support` for developing Java applications.
- It is modular, meaning you can use only the parts you need.
- It provides features like `Inversion of Control (IoC)`, `Dependency Injection (DI)`, `Aspect-Oriented Programming (AOP)`, and more.
- It is designed to be flexible and can be used with various data access technologies, such as JDBC, JPA, Hibernate, and more.
- It is the foundation for Spring Boot, which simplifies the development of Spring applications.

## Spring Boot (Framework built on top of Spring)
- It is a framework built on top of the Spring Framework that simplifies the development of production-grade Spring based applications with minimal configuration.
- It includes features like autoconfiguration, embedded servers (like Tomcat, Jetty), and production-ready features (like health checks, metrics).

## Spring Container
- It is the core of the Spring framework.  
- It is an `Engine` that manages everything in the Spring application.    
- It is responsible for creating, configuring, and managing the lifecycle of Spring beans (i.e. objects).    
- It resolves dependencies via @Autowired, @Inject, or constructor injection.  
- Key Role:  It implements Inversion of Control (IoC) and Dependency Injection (DI) patterns.

#### Types of Spring Containers
- **BeanFactory**: The simplest container that provides basic support for DI. It is lightweight and suitable for simple applications.
- **ApplicationContext**: advanced container - includes BeanFactory + more features like event propagation, internationalization, and more. It is the most commonly used container in Spring applications.  
  - **ClassPathXmlApplicationContext**: Loads the context definition from an XML file located in the classpath.  
  - **FileSystemXmlApplicationContext**: Loads the context definition from an XML file located in the filesystem.  
  - **AnnotationConfigApplicationContext**: A container that supports Java-based configuration using annotations. It is used for applications that prefer annotation-based configuration over XML-based configuration.  

## Spring Context: (or, ApplicationContext)   
- It is an Interface to the Spring Container.
- It is a specific type of Spring Container.   
- Note: In modern Spring (Spring Boot, Spring 3+), ApplicationContext is the standard.

```
BeanFactory (basic container) <── ApplicationContext (advanced container)
↑
Spring Container (umbrella term)
```

## Spring Beans
Objects that are managed by the Spring Container. They are created, configured, and managed by the Spring Container.