FROM openjdk:26-ea-slim-trixie AS builder
WORKDIR /app
COPY . .
RUN sed -i 's/\r$//' mvnw

RUN chmod +x mvnw


RUN   ./mvnw clean package -DskipTests

FROM openjdk:26-ea-slim
WORKDIR /app
COPY --from=builder /app/target/course-tracker-app-dockerfile-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]
EXPOSE 8080