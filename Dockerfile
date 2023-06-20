# Stage 1: Build the application
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /company-crud
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Set up the runtime environment
FROM openjdk:17-jdk-slim AS runtime
WORKDIR /company-crud

# Copy the built JAR file from the previous stage
COPY --from=build /company-crud/target/company-crud.jar .

# Expose the port on which the application will run
EXPOSE 8080

# Specify the command to run the application
CMD ["java", "-jar", "company-crud.jar"]
