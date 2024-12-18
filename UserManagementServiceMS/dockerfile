FROM openjdk:17-jdk-slim AS build
WORKDIR /app
COPY build/libs/my-UserService-App.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
