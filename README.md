# Desafio - Sistema de Planetas

## Visão Geral

O projeto "Desafio - Sistema de Planetas" é uma API que gerencia informações sobre planetas. É baseado
no [desafio de backend da Ame Digital](https://github.com/AmeDigital/challenge-back-end-hit) O sistema
permite a
criação, listagem, busca por ID, busca por nome e remoção de planetas. Além disso, utiliza a API SWAPI (Star Wars API)
para obter informações adicionais sobre os planetas, como a quantidade de aparições em filmes de Star Wars.

## Tecnologias Usadas

- **Spring Boot**
- **Java**
- **Maven**
- **Docker**
- **PostgreSQL**
- **Spring Data JPA**

### Pacotes

- **entities**: Contém a definição da entidade Planeta.
- **usecases**: Contém os casos de uso da aplicação.
- **repositories**: Contém os repositórios relacionados a operações no banco de dados.
- **controllers**: Contém os controladores da API.
- **controllers/handlers**: Contém manipuladores de exceção para tratamento de erros.
- **dtos**: Contém os DTOs (Data Transfer Objects) utilizados para comunicação com a API.
- **config**: Contém a configuração do projeto, como o arquivo de configuração do Swagger.
- **services**: Contém arquivos de serviços externos.

### Configuração

1. Clone o repositório.
2. Utilize `docker-compose up` para iniciar os containers do PostgreSQL.

### Endpoints

- Ao rodar a aplicação disponível em:   `http://localhost:8080/swagger-ui/index.html#/`
