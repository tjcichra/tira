FROM openjdk:11 AS builder
WORKDIR /app
COPY . .
CMD ./gradlew bootJar

FROM openjdk:11-jre
WORKDIR /app
COPY --from=builder /app/build/libs/tira-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar -Dspring.datasource.url=jdbc:postgresql://tiradb/tira tira-0.0.1-SNAPSHOT.jar
