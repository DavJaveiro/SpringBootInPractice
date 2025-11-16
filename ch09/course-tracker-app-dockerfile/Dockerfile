# ===========================
# 1) STAGE DE BUILD (Maven + JDK)
# ===========================
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn -e -B dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

# ===========================
# 2) STAGE DE RUNTIME (somente JRE)
# ===========================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
