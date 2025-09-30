# Wise Buddy API

## Descrição

API para gerenciamento de usuários, contratos, pagamentos, planos, cartões, sessões, recomendações e suitability, desenvolvida em Java 17 com Spring Boot. Permite operações CRUD e integra serviços relacionados ao universo financeiro, como cadastro de usuários, contratação de planos, registro de cartões, pagamentos, sessões de atendimento e recomendações personalizadas.

---

## Integrantes

- **Caíque Walter Silva** - RM550693
- **Carlos Eduardo Caramante Ribeiro** – RM552159
- **Felipe Heilmann Marques** – RM551026
- **Guilherme Nobre Bernardo** - RM98604
- **Matheus José de Lima Costa** - RM551157

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL** (banco de dados relacional)
- **Docker** (containerização do banco)
- **Swagger/OpenAPI** (documentação dos endpoints)
- **Lombok** (facilita geração de código)
- **JUnit** (testes unitários)

---

## Passos de Configuração e Execução

### 1. Subindo o Banco de Dados (MySQL) com Docker

Execute o comando abaixo para criar e iniciar o banco de dados `wisebuddy`:

```bash
docker run --name wisebuddy-mysql -e MYSQL_ROOT_PASSWORD=123 -e MYSQL_DATABASE=wisebuddy -p 3306:3306 -d mysql:8.0
```

### 2. Configurando a Porta da API

Defina a porta 8085 no arquivo `src/main/resources/application.properties` (crie se não existir):

```properties
server.port=8085
```

### 3. Rodando a API

1. **Clone o repositório**
2. **Configure o `application.properties`** conforme necessário (usuário, senha, URL do banco etc)
3. **Compile e execute o projeto**:

```bash
./mvnw spring-boot:run
```
ou
```bash
mvn spring-boot:run
```

---

## Documentação Swagger

Após iniciar a API, acesse a documentação interativa pelo navegador:

[http://localhost:8085/swagger-ui/index.html](http://localhost:8085/swagger-ui/index.html)

---

## Exemplos de Requisições e Respostas

### Usuários

**Registrar usuário**
```http
POST /wise-buddy/v1/users/register
Content-Type: application/json

{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123456"
}
```
**Resposta**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com"
}
```

**Login**
```http
POST /wise-buddy/v1/users/login
Content-Type: application/json

{
  "email": "joao@email.com",
  "senha": "123456"
}
```
**Resposta**
```json
{
  "token": "jwt.token.aqui",
  "id": 1,
  "nome": "João Silva"
}
```

---

### Contratos

**Criar contrato**
```http
POST /wise-buddy/v1/contracts
Content-Type: application/json

{
  "userId": 1,
  "planId": 2,
  "contractDate": "2025-09-20"
}
```
**Resposta**
```json
{
  "id": 10,
  "userId": 1,
  "planId": 2,
  "contractDate": "2025-09-20"
}
```

---

### Planos

**Buscar todos os planos**
```http
GET /wise-buddy/v1/plans
```
**Resposta**
```json
[
  {
    "id": 1,
    "nome": "Plano Básico",
    "descricao": "Serviço básico",
    "valor": 50.0
  },
  {
    "id": 2,
    "nome": "Plano Avançado",
    "descricao": "Serviço avançado",
    "valor": 100.0
  }
]
```

---

### Pagamentos

**Criar pagamento**
```http
POST /wise-buddy/v1/payments
Content-Type: application/json

{
  "userId": 1,
  "planId": 2,
  "amount": 100.00,
  "paymentDate": "2025-09-20"
}
```
**Resposta**
```json
{
  "id": 5,
  "userId": 1,
  "planId": 2,
  "amount": 100.00,
  "paymentDate": "2025-09-20"
}
```

---

### Cartões

**Criar cartão**
```http
POST /wise-buddy/v1/cards
Content-Type: application/json

{
  "userId": 1,
  "cardNumber": "1234 5678 9012 3456",
  "cardType": "credit",
  "expirationDate": "12/28",
  "cvv": "123"
}
```
**Resposta**
```json
{
  "id": 7,
  "userId": 1,
  "cardNumber": "1234 5678 9012 3456",
  "cardType": "credit",
  "expirationDate": "12/28"
}
```

---

### Recomendações

**Criar recomendação**
```http
POST /wise-buddy/v1/recommendations/request
Content-Type: application/json

{
  "userId": 1,
  "sessionId": 1,
  "suitabilityId": 1,
  "recommendation": "Exemplo de recomendação"
}
```
**Resposta**
```json
{
  "id": 3,
  "userId": 1,
  "sessionId": 1,
  "suitabilityId": 1,
  "recommendation": "Exemplo de recomendação"
}
```

---

### Sessões

**Criar sessão**
```http
POST /wise-buddy/v1/sessions
Content-Type: application/json

{
  "userId": 1,
  "sessionDate": "2025-09-20"
}
```
**Resposta**
```json
{
  "id": 4,
  "userId": 1,
  "sessionDate": "2025-09-20"
}
```

---

### Suitability

**Criar suitability**
```http
POST /wise-buddy/v1/suitabilities
Content-Type: application/json

{
  "userId": 1,
  "json": "{\"perfil\": \"Conservador\"}"
}
```
**Resposta**
```json
{
  "id": 2,
  "userId": 1,
  "perfil": "Conservador"
}
```

---

### Observações

- A porta padrão da API agora é **8085**.
- A porta padrão do banco de dados MySQL é **3306**.
- O usuário padrão do MySQL é **root** e a senha é **123** (conforme comando acima).
- Certifique-se de que a porta 3306 não esteja em uso por outro serviço MySQL local.
- Caso utilize outro perfil/ambiente, garanta que `server.port=8085` esteja definido ou sobrescrito corretamente.

---
