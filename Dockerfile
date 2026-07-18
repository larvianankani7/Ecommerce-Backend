# --- Stage 1: Build the Maven application ---
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Copy the dependency management files first to cache them
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the actual project source code
COPY src ./src

# Compile and package the application into a JAR file, skipping unit tests for speed
RUN mvn clean package -DskipTests

# --- Stage 2: Create the runtime environment ---
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the compiled JAR file from the builder stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 so Render can forward internet traffic into it
EXPOSE 8080

# Run the jar with optimized memory management for small container limits
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]