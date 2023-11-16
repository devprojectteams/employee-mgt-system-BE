# Build stage
FROM maven:3.8.7 as build
COPY . /app
WORKDIR /app
RUN mvn -B clean package -DskipTests

# Run stage
FROM openjdk:17
COPY --from=build ./target/*.jar app.jar
ENV PORT=8080
ENV PROFILE=default
ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}", "-Dspring.profiles.active=${PROFILE}", "app.jar"]