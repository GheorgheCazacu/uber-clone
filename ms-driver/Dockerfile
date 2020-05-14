FROM openjdk:8-jdk-alpine

EXPOSE 5151

ADD ./target/ms-driver*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
