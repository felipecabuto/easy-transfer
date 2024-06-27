# Easy Transfer API

Uma API para agendamento de transferências financeiras, onde os usuários podem agendar transferências com regras de taxação dependendo do valor e data que é realizada.
## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2.1
- Maven 3.9.6
- Vue.js 3 (para o front-end)

## Pré-requisitos

Antes de iniciar, certifique-se de que tem instalado:
- JDK 17 [versão recomendada]
- Maven 3.9.6 [versão recomendada]
- Node.js 18.x [versão recomendada]
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VSCode, etc.)

## Back-end (Spring Boot)
### Como Subir a Aplicação

1. Clone o repositório:
   ```bash
   git clone [URL do repositório]
2. Navegue até a pasta do projeto:
   ```bash
   cd easy-transfer
3. Para iniciar a aplicação, execute:
   ```bash
   ./mvnw spring-boot:run

### Endpoints da API:

- `POST /transferencias` - Agenda uma nova transferência
- `GET /transferencias` - Lista todas as transferências agendadas

### Para executar os testes unitários:

1. Navegue até a pasta do projeto:
   ```bash
   cd easy-transfer
2. Execute os testes com o comando:
   ```bash
   ./mvnw test

## Front-end (Vue.js)
### Como Subir a Aplicação

1. Navegue até a pasta do projeto:
   ```bash
   cd easy-transfer/frontend
2. Instale as dependências:
   ```bash
   npm install
4. Execute os testes com o comando:
   ```bash
   npm run test

### Como Rodar o Front-end
1. Certifique-se que o Axios está instalado
   ```bash
   npm install axios
2. Acessar pasta
   ```bash
   cd .\front-end\
3. Rodar a aplicação
   ```bash
   npm run serve
4. Acessar localmente
   ```bash
   http://localhost:8081/

## Arquitetura
### Separação de Responsabilidades
O projeto está dividido em duas partes: o back-end (Java Spring Boot), e front-end (Vue.js) separando a lógica de negócios e a interface do usuário.
### Persistência de Dados
Para a persistência de dados, foi utilizado o banco de dados em memória H2 e Spring Data JPA para simplificar a manipulação de dados.
### Gerenciamento de Dependências
O Maven foi escolhido como a ferramenta de gerenciamento de dependências para o projeto back-end. No front-end, o npm é usado para gerenciar as dependências do Vue.js.