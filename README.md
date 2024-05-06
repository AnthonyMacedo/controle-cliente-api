# Controle Cliente API
Este é um projeto de exemplo para um sistema de cadastro de clientes, onde os detalhes dos clientes, incluindo endereço completo com dados de geolocalização, podem ser armazenados.


# Tecnologias Utilizadas
- Spring Framework
- PostgreSQL 14
- Docker
- Maven
- Flyway
- Swagger
  
## Pré-requisitos
Certifique-se de ter as seguintes tecnologias instaladas em sua máquina:

- Docker
- Java Development Kit (JDK)  17
- Maven
 
## Configuração e Execução do Projeto com Docker Compose
Clone este repositório para a sua máquina local:
```bash
git clone https://github.com/AnthonyMacedo/controle-cliente-api.git
```
Navegue até o diretório do projeto:
```bash
cd controle-cliente-api
```
Execute o seguinte comando para iniciar o aplicativo usando Docker Compose:
```bash
docker-compose up --build
```
Isso iniciará o contêiner Docker com o PostgreSQL 14 com o database criado.

O projeto deve estar disponível em http://localhost:8080/controle-cliente-api.

Acesse a documentação da API Swagger em: http://localhost:8080/swagger-ui/index.html.
