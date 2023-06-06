# Define base Docker image
FROM maven:3.8.4-openjdk-17-slim

# Set the working directory
WORKDIR /company-crud

# Copy the project files to the container
COPY . .

# Build the application
RUN mvn package -DskipTests

# Expose the port on which the application will run
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "target/company-crud.jar"]