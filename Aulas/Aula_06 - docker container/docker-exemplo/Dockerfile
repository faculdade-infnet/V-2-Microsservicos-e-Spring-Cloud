FROM openjdk:26-ea-23-jdk-slim-bookworm
ARG JARFILE=target/*.jar
COPY ${JARFILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# tags[simple tags] openjdk = https://hub.docker.com/_/openjdk
# simles/leve 26-ea-23-jdk-slim-bookworm
# completa 26-ea-23-jdk-oraclelinux9
