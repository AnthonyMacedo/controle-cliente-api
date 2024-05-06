# Controle Cliente API
Este é um projeto de exemplo para um sistema de cadastro de clientes, onde os detalhes dos clientes, incluindo endereço completo com dados de geolocalização, podem ser armazenados.


# Tecnologias Utilizadas
- Spring Framework
- PostgreSQL 14
- Docker
- Maven
- Flyway
  
## Pré-requisitos
Certifique-se de ter as seguintes tecnologias instaladas em sua máquina:

- Docker
- Java Development Kit (JDK)  17
- Maven

 ## Instruções de configuração

 A baixo possui um passo a passo a ser seguido:
  1 - Criar imagem do postgres e criar o database:

 
  
## Configuração do Banco de Dados
Certifique-se de que o Docker está em execução na sua máquina.
Execute o seguinte comando para iniciar um contêiner Docker com o PostgreSQL 14:
```bash
docker run --name db-controle-cliente -e POSTGRES_PASSWORD=admin -p 5432:5432 -d postgres:14.10-alpine
```
## Configuração e Execução do Projeto
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
