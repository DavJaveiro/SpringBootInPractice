FROM eclipse-temurin:17-jdk
ADD target/*.jar application.jar
ENTRYPOINT ["java", "-jar","application.jar"]
EXPOSE 8080