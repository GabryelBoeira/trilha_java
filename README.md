# Trilha Java

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3
- Gradle
- H2 Database (ambiente de desenvolvimento)
- Docker e Docker Compose
- Spring Data JPA
- Spring Web
- **Apache Kafka** (Streaming de eventos)
- **Springdoc OpenAPI** (Documentação Swagger)

## Execução do Projeto

### Pré-requisitos
- Java 21 JDK
- Gradle 8+
- Docker e Docker Compose instalados

### Comandos Básicos
```bash
# Build do projeto
./gradlew build

# Subir containers (Kafka + Aplicação)
docker-compose up -d
```

## Configuração de Ambiente
Crie/atualize o arquivo `.env` com suas configurações locais antes de executar o docker-compose.
```
KAFKA_BOOTSTRAP_SERVERS=localhost:9092
```

## Acesso
- Swagger UI: http://localhost:8080/swagger-ui.html
- Kafka UI (Kafdrop): http://localhost:9000/kafdrop/
- H2 Console: http://localhost:8081/h2-console
