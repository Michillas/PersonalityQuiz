# Use official Maven image as a build stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn -f /app/pom.xml clean package

# Expose port 8080
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/target/PersonalityQuiz.jar"]
