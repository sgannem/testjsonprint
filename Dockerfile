FROM openjdk:8-jdk-alpine
#FROM openjdk:8
COPY target/testjsonprint-0.0.1-SNAPSHOT.jar testjsonprint.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "testjsonprint.jar"]