FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/my-datastoreservice-app.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
