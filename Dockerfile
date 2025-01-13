# Use the Java 21 base image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/Ecommerce-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Define the entry point
ENTRYPOINT ["java", "-jar", "app.jar"]
