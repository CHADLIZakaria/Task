FROM eclipse-temurin:21-jre
WORKDIR /app
COPY /target/task-backend*.jar /app/task-backend.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/task-backend.jar"]
