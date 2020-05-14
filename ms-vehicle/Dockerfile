FROM openjdk:8-jdk-alpine

EXPOSE 8181

ADD ./target/ms-vehicle*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
