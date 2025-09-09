# Stage 1: Build the application
# Use a Maven builder image to package the app
FROM maven:3.9.6-eclipse-temurin-21-slim AS builder

# Set the working directory
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .

# Copy the source code
COPY src ./src

# Build the application and create the executable JAR file
RUN mvn clean package -DskipTests

# Stage 2: Create the final production image
# Use a lightweight JDK image
FROM eclipse-temurin:21-jre-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/devicedata-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application listens on
EXPOSE 8080

# The command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]