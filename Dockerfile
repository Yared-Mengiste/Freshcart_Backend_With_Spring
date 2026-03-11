# Stage 1: Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# 1. Copy the pom.xml from the subfolder to the current workdir in Docker
COPY freshcart/pom.xml .

# Download dependencies (this layer is cached if pom.xml doesn't change)
RUN mvn dependency:go-offline -B

# 2. Copy the source code from the subfolder
COPY freshcart/src ./src

# Build the application
# Because we copied pom.xml to /app/, the jar will be in /app/target/
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Create a non-root user for security
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring

# 3. Copy the jar from the build stage target folder
COPY --from=build /app/target/*.jar app.jar

# Your API is running on 8081
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]