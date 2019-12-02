# Microservices-With-Spring

This is a demo project for spring microservices communication.
It includes:
1. ConfigData folder with just one file - application.yml
This file contains the configuration needed for our microservices.
2. config-server, through which microservices can obtain their configuration.
3. eureka-server - service discovery, where microservices register themselves.
4. sentence-microservice - the goal of this microservice is just to build the sentence.
In order to do this, sentence-microservice need to make 5 calls to different instances of word-microservice.
5. word-microservice - this microservice generates random words (subject, verb, adjective, article, noun).
It must be run 5 times with 5 different profiles (subject, verb, adjective, article, noun).

URLs:
config-server: http://localhost:8001;
eureka-server: http://localhost:8010;
sentence-microservice: http://localhost:8020/sentence;

Sentence-microservice uses FeignClient for making calls to word-microservices. It also uses Hystrix for fault tolerance.
This project also makes use of Spring Cloud Bus and RabbitMQ for runtime configuration change apply. 
In order to refresh configuration in runtime, you must hit this endpoint: http://localhost:8001/actuator/bus-refresh
