# Use the official OpenJDK 20 image as a parent image
FROM amazoncorretto:latest

# Set the working directory inside the container
#WORKDIR /app

# Copy the Spring Boot application JAR file to the container
COPY ./target/*.jar spring-application.jar

## Expose port 8080 to the outside world
EXPOSE 8082

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/spring-application.jar"]

