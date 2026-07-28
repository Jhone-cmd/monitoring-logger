# Monitoring Logger

Projeto desenvolvido para monitorar logs de uma aplicação, com foco em registrar e acompanhar incidentes gerados durante a execução do sistema. A ideia principal é centralizar informações importantes da aplicação em uma estrutura simples, organizada e fácil de consultar, funcionando como uma base de estudo prática sobre monitoramento de logs.

Este projeto foi feito assistindo às videoaulas da plataforma RocketSeat.

## Visão Geral

A aplicação é uma API Spring Boot que permite:

- cadastrar incidentes com nome, descrição e categoria;
- listar todos os incidentes salvos;
- registrar logs em pontos importantes do fluxo da aplicação;
- persistir os dados em banco H2 em memória;
- acessar o console do H2 durante o desenvolvimento.

O foco do projeto é entender como uma aplicação pode ser observada por meio de logs, desde a inicialização até o processamento das requisições.

## Tecnologias e Bibliotecas Utilizadas

### Plataforma

- Java 21
- Spring Boot 4.1.0

### Dependências principais

- `spring-boot-starter-webmvc`: criação da API REST e controle das requisições HTTP;
- `spring-boot-starter-data-jpa`: persistência e acesso ao banco de dados via JPA;
- `spring-boot-starter-validation`: validação dos dados enviados no payload;
- `h2`: banco de dados em memória para desenvolvimento e testes;
- `spring-boot-h2console`: acesso ao console web do H2;
- `spring-boot-devtools`: suporte a recarga automática durante o desenvolvimento;
- `lombok`: redução de código repetitivo com anotações como `@Data`, `@Builder`, `@AllArgsConstructor` e `@NoArgsConstructor`;
- dependências de teste do Spring Boot para suporte a testes de contexto e camada web/JPA.

### Observação sobre logs

O projeto utiliza `SLF4J` com `LoggerFactory` por meio da classe utilitária `AppLogger`, padronizando a criação de logs nas camadas da aplicação.

## Funcionalidades

### 1. Cadastro de incidentes

O endpoint de criação recebe um objeto com:

- `name`
- `description`
- `category`

Ao receber a requisição, a aplicação:

- registra logs de entrada;
- converte o DTO em entidade;
- salva o incidente no banco;
- retorna resposta `201 Created`.

### 2. Listagem de incidentes

O endpoint de listagem retorna todos os incidentes persistidos.

Durante a consulta, a aplicação também registra logs para facilitar a observação do fluxo.

### 3. Monitoramento da inicialização

Ao subir a aplicação, a classe `StartApp` executa um log informando que o servidor foi iniciado.

## Estrutura de Pastas

```text
src/
  main/
    java/com/jhonecmd/monitoring/logger/
      Application.java
      controller/
        IncidentController.java
      dto/
        IncidentDTO.java
      model/
        Category.java
        IncidentEntity.java
      repository/
        IncidentRepository.java
      service/
        IncidentService.java
      startApp/
        StartApp.java
      utils/
        AppLogger.java
    resources/
      application.properties
  test/
    java/com/jhonecmd/monitoring/logger/
      ApplicationTests.java
```

## Responsabilidade de Cada Parte

### `Application.java`

Classe principal da aplicação Spring Boot. É o ponto de entrada da execução.

### `controller/IncidentController.java`

Exponibiliza os endpoints REST para criação e consulta de incidentes.

### `dto/IncidentDTO.java`

Representa o payload recebido pela API no momento do cadastro de um incidente.

### `model/IncidentEntity.java`

Entidade JPA persistida na tabela `incidents`.

### `model/Category.java`

Enum com as categorias disponíveis para os incidentes:

- `BUG`
- `INFO`
- `ERROR`
- `WARN`
- `FAIL`

### `repository/IncidentRepository.java`

Interface JPA responsável pelo acesso ao banco de dados.

### `service/IncidentService.java`

Camada de regra de negócio responsável por processar e buscar incidentes.

### `startApp/StartApp.java`

Executa uma ação ao iniciar a aplicação e registra um log de startup.

### `utils/AppLogger.java`

Classe utilitária que centraliza a criação dos loggers da aplicação.

## Estrutura do Fluxo

1. A requisição chega ao controller.
2. O controller registra logs e monta a entidade a partir do DTO.
3. O service processa o incidente e envia para o repositório.
4. O repositório persiste os dados no banco H2.
5. O controller devolve a resposta para o cliente.

Esse fluxo foi pensado para facilitar o acompanhamento por logs, deixando visível o caminho percorrido por cada incidente dentro da aplicação.

## Endpoints

### `POST /incidents`

Cria um novo incidente.

Exemplo de payload:

```json
{
  "name": "Falha no login",
  "description": "O usuário não conseguiu autenticar na aplicação",
  "category": "ERROR"
}
```

Resposta esperada:

- `201 Created`

### `GET /incidents`

Retorna a lista de todos os incidentes cadastrados.

## Configuração da Aplicação

O arquivo `application.properties` define:

- nome da aplicação;
- conexão com banco H2 em memória;
- console web do H2 habilitado;
- comportamento do Hibernate com `ddl-auto=update`.

### Console H2

Durante a execução, o console do H2 fica disponível em:

```text
/h2-console
```

Credenciais configuradas:

- usuário: `sa`
- senha: vazia

## Como Executar

### Pré-requisitos

- Java 21 instalado;
- Maven instalado, ou uso do wrapper `mvnw` incluso no projeto.

### Executando com Maven Wrapper

```bash
./mvnw spring-boot:run
```

### Executando os testes

```bash
./mvnw test
```

## Testes

O projeto possui uma estrutura básica de testes com `ApplicationTests`, validando se o contexto do Spring sobe corretamente.

## Objetivo Educacional

Além de funcionar como uma API simples de incidentes, este projeto serve como exercício prático para entender:

- organização em camadas;
- uso de JPA com banco em memória;
- validação de entrada;
- criação e padronização de logs;
- observabilidade básica da aplicação.

## Autoría e Contexto

Projeto criado como parte do aprendizado com as videoaulas da RocketSeat, com foco em consolidar conceitos de monitoramento de logs e estruturação de aplicações Spring Boot.