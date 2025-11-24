# imagem base
FROM eclipse-temurin:21-jdk

# Copia o arquivo "kubernetes-0.0.1-SNAPSHOT.jar" da pasta "target/" para dentro do  container com o nome app.jar.
COPY target/kubernetes-0.0.1-SNAPSHOT.jar /app.jar

# Executa automaticamente assim que o container for iniciado.
ENTRYPOINT ["java", "-jar", "/app.jar"]

