FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY target/TP3-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Xms128m","-Xmx512m","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
