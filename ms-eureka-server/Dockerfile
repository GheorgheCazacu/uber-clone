FROM openjdk:8-jdk-alpine

EXPOSE 8761

ADD ./target/ms-eureka-server*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
