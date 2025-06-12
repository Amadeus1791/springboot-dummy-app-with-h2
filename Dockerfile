FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN chmod +x mvnw
COPY src src
RUN ./mvnw clean package -DskipTests
EXPOSE 10000
CMD java -jar target/*.jar