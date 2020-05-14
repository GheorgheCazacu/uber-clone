FROM openjdk:8-jdk-alpine

EXPOSE 7171

ADD ./target/ms-trip*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
