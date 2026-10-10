# --- Etapa 1: compilar el .jar con Maven y Java 8 ---
FROM maven:3.8.8-eclipse-temurin-8 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -B -q dependency:go-offline
COPY src ./src
RUN mvn -B -q package -DskipTests

# --- Etapa 2: imagen liviana solo con el JRE ---
FROM eclipse-temurin:8-jre
WORKDIR /app
COPY --from=build /app/target/portfolio-ap-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
# La instancia gratuita de Koyeb tiene 512 MB de RAM
ENV JAVA_OPTS="-Xmx300m -Xss512k -XX:+UseSerialGC"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
