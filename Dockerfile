FROM openjdk:17-jdk-slim

COPY target/IAMSystem-0.0.1-SNAPSHOT.jar IAMSystem-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","IAMSystem-0.0.1-SNAPSHOT.jar"]