FROM maven:3.6.3-jdk-11 AS builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk

WORKDIR /app

COPY --from=builder  /app/target/search-suggestion-service.jar .

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "search-suggestion-service.jar"]