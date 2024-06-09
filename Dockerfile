# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code into the container
COPY src ./src

# Package the application
RUN mvn clean package

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the build stage to the run stage
COPY --from=build /app/target/*.jar /app/usermanagement.jar

# Expose port 8090
EXPOSE 8090

# Run the application
ENTRYPOINT ["java", "-jar", "usermanagement.jar"]
