# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

FROM openjdk:11

COPY target/restapi-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]