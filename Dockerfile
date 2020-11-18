FROM openjdk:8-jdk-alpine
ARG JAR_FILE=/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/my-primer-app.jar"]