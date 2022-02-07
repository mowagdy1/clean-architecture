FROM openjdk:17-oracle
MAINTAINER mowagdy
COPY target/base-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]