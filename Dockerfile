FROM openjdk:21-jdk-slim

WORKDIR /app
COPY build/libs/*.jar app.jar

EXPOSE 5005
EXPOSE 8080

ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "app.jar"]