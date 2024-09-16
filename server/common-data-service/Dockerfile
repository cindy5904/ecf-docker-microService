FROM maven:3.6.3-jdk-11 AS builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk

WORKDIR /app

COPY --from=builder  /app/target/common-data-service.jar .

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "common-data-service.jar"]