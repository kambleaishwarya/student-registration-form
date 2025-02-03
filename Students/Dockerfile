# Use official Maven image to build the app
FROM maven:3.8.6-openjdk-17-slim AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code into the image
COPY src /app/src

# Package the application
RUN mvn clean package -DskipTests

# Use official OpenJDK image to run the app
FROM openjdk:17-jdk-slim

# Set the working directory in the runtime container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/student-registration-form.jar /app/student-registration-form.jar

# Expose the port the app will run on
EXPOSE 8888

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/student-registration-form.jar"]
