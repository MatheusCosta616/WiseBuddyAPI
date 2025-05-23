Comando para criar o banco de dados DOCKER

docker run --name wisebuddy-mysql -e MYSQL_ROOT_PASSWORD=123 -e MYSQL_DATABASE=wisebuddy -p 3306:3306 -d mysql:8.0


REQUISITOS DA API:
- Java 17
- Docker