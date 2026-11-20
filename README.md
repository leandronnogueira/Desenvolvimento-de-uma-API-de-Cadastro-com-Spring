## Docker
Na pasta do projeto:

```
docker compose up --build
```

Isso sobe o banco e A API fica em `http://localhost:8081`.

## Sem Docker

Com um MariaDB rodando em `localhost:3306` usuário `root`, senha `root` e banco `cadastrocarros`:

```
./mvnw spring-boot:run
```