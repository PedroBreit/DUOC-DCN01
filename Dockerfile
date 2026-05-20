FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/inscripciones-0.0.1-SNAPSHOT.jar app.jar

COPY wallet /app/wallet

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]