# Use the official OpenJDK 20 image as a parent image
FROM amazoncorretto:latest


#WORKDIR /app


COPY ./target/*.jar spring-application.jar

EXPOSE 8082

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/spring-application.jar"]

