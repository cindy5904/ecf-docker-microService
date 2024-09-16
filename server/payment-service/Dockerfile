FROM maven:3.6.3-jdk-11 AS builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk

WORKDIR /app

COPY --from=builder  /app/target/payment-service.jar .

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "payment-service.jar"]