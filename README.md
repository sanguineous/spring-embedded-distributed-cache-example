### Embedded distributed cache with Spring Boot and Hazelcast example

This is a simple service that respnd with "Hello, <name>!", after 1000 milliseconds, when you request 
```GET http://localhost:8080/cachedGreeting?delay=1000&name=<name>```.

The service is also cached, so if you make the same request a second time, you get the result without the 1000 ms delay.

The cache is also distributed, so even if the second request is made to another instance of the service, the response is not deleyed (see CacheApplicationIT class).

This is an implemetation example of a distributed embedded cache architecture, as explained here: https://hazelcast.com/blog/architectural-patterns-for-caching-microservices/

## How to work with this repository

### Machine setup
Because a .devcontaner is provided, the fastest way to work with this project code is to open the repository with github Codespaces.

Alternatively, if you have Docker installed and VSCode with Dev Container extension, you can run from VSCode ```F1->Devcontainers: Clone a repository...```.

Anyway, if you want to manual setup your machine, you should read .devcontainer file to figure out which is the setup to perform as it may evolves (at the time, only a jdk 17 is needed). 

### Build and run/test the application
Simply execute ```mvnw verify``` to build, deploy and run the application (it launchs 2 service instances), execute acceptance tests and finally stop the application.
If you don't want to undeploy the application and you want to make code changes that are automatically deployed, execute instead ```mvnw integration-test```.
