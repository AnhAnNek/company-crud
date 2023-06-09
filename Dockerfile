# Use an official Maven image as the base image
FROM maven:3.8.3-openjdk-11 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code to the container
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use an official OpenJDK image as the base image for running the application
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/company-crud.jar .

# Specify the command to run your application
CMD ["java", "-jar", "company-crud.jar"]