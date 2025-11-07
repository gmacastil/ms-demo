FROM eclipse-temurin:21.0.8_9-jre

COPY target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]