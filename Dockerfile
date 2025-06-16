FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

FROM eclipse-temurin:23-jdk
WORKDIR /app
COPY --from=build /app/target/quest.war ./quest.war
COPY webapp-runner.jar ./webapp-runner.jar


CMD ["java", "-jar", "webapp-runner.jar", "--port", "8080", "quest.war"]
