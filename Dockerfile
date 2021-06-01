FROM openjdk:11
WORKDIR /app
COPY build/libs/tira-0.0.1-SNAPSHOT.jar .
CMD java -jar -Dspring.datasource.url=jdbc:mariadb://tiradb/tira tira-0.0.1-SNAPSHOT.jar