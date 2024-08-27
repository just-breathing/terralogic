# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file to the container
COPY ./ /app/

# Expose the port your Spring Boot application will run on
EXPOSE 8081

# Run the application
CMD["mvn", "spring-boot:run"]
