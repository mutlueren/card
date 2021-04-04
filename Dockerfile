FROM adoptopenjdk/openjdk11:latest
EXPOSE 8081
ARG JAR_FILE=target/card-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]