# Stage 1: Build the React frontend
FROM node:20 AS frontend-build
WORKDIR /app
COPY ui/package*.json ./
RUN npm install
COPY ui/ ./
RUN npm run build

# Stage 2: Build the Spring Boot backend
FROM maven:3.9.8-amazoncorretto-21-debian-bookworm AS backend-build
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:go-offline
COPY /src/ ./src
RUN mvn clean package -Dmaven.test.skip=true

# Stage 3: Create the final image
FROM openjdk:21-jdk-slim-bullseye
RUN apt-get update && apt-get install -y iputils-ping
RUN apt-get install -y net-tools
RUN apt-get install -y curl
WORKDIR /app
COPY /src/dataset ./src/dataset
COPY --from=backend-build /app/target/*.jar app.jar
COPY --from=frontend-build /app/build ./ui/build
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]