# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file to the container
COPY target/nodes-0.0.1-SNAPSHOT.jar /app/user.jar

# Expose the port your Spring Boot application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","/app/user.jar"]
