FROM eclipse-temurin:21-jdk
WORKDIR /app

ARG JAR_FILE=target/inventory*.jar
COPY ${JAR_FILE} app.jar
# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]