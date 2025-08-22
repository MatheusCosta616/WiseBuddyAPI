# Etapa 1: Usar uma imagem base com JDK (Java Development Kit)
FROM openjdk:17-jdk-slim

# Etapa 2: Configurar diretório de trabalho dentro do contêiner
WORKDIR /app

# Etapa 3: Copiar o arquivo JAR gerado pelo Spring Boot para o contêiner
COPY target/wiseBuddy-0.0.1-SNAPSHOT.jar app.jar

# Definir o perfil ativo como prod
ENV SPRING_PROFILES_ACTIVE=prod

# Etapa 4: Especificar o comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]