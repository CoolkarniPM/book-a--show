# event-service/Dockerfile
FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/event-service-0.0.1-SNAPSHOT.jar event-service.jar
ENTRYPOINT ["java","-jar","/event-service.jar"]
