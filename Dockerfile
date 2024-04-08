# Use official Maven image as a build stage
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use official OpenJDK 17 image as base
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copy the packaged JAR file from the build stage to the container
COPY --from=build /app/target/PersonalityQuiz-1.0-SNAPSHOT.jar /app

# Expose port 8080
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "PersonalityQuiz-1.0-SNAPSHOT.jar"]
