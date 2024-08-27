# Use an official OpenJDK runtime as a parent image
FROM amazoncorretto:17-alpine-jdk

# Set the working directory inside the container

# Copy the application JAR file to the container

COPY target/*.jar /app/user.jar

WORKDIR /app

# Expose the port your Spring Boot application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","user.jar"]
