### Embedded distributed cache with Spring Boot and Hazelcast example

This is a simple service that respnd with "Hello, <name>!", after 1000 milliseconds, when you request GET http://localhost:8080/cachedGreeting?delay=1000&name=<name>.
The service is also cached, so if you make the same request a second time, you get the result without the 1000 ms delay.
The cache is also distributed, so even if the second request is made to another instance of the service, the response is not deleyed (see CacheApplicationIT class).
This is an implemetation example of a distributed embedded cache architecture, as explained here (https://hazelcast.com/blog/architectural-patterns-for-caching-microservices/)

## How to run

Simply execute mvnw verify to build and test the case with 2 service instances that shares a cache.
