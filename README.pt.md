# Skyline Ground API 🏢

Sistema de gestão imobiliária para controle de projetos, construções, ativos e finanças, integrando inventário,
contratos e auditoria centralizada para administradores.

## Idiomas

- [Inglês](README.md)

## Tecnologias Usadas

O projeto foi desenvolvido usando **Java 17** e **Spring Boot 3.5.11**.

- **Framework**: Spring Boot (Web, Data JPA, Security, Validation)
- **Banco de Dados**: PostgreSQL
- **Gestão de Migrações**: Flyway
- **Segurança**: Java-JWT
- **Utilitários**: Lombok
- **Conteinerização**: Docker

## Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:

- [Git](https://git-scm.com)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Docker](https://www.docker.com/)

## Instalação e Execução

### 1. Clonar o repositório

```bash
git clone [https://github.com/CleinerFG/skyline-ground-api.git](https://github.com/CleinerFG/skyline-ground-api.git)
cd skyline-ground-api
```

### 2. Iniciar o banco de dados com o Docker

```bash
docker-compose up -d
```

### 3. Configurar variáveis de ambiente

- Crie um arquivo `.env` na raiz do projeto e
  configure as credenciais de acesso ao banco de dados e da aplicação.

Exemplo:

```bash
DB_POSTGRES_USERNAME=username
DB_POSTGRES_PASSWORD=password
DB_POSTGRES_URL=jdbc:postgresql://localhost:5432/skyline-ground
JWT_SECRET=jwt-secret-hash
JWT_ISSUER=skyline-ground
```

- Configure sua IDE para usar variáveis de ambiente.

Configuração IntelliJ IDEA:

```bash
Run > Edit Configurations > Add New Configuration > Aplication
```

Preencha:

- `Name`: Skyline Ground App
- `Main Class`: com.skylineground.SkylineGroundApplication
- `Environment variables`: ../skyline-ground-api/.env

`Nota`: Em *Environment variables*, coloque o caminho completo para o arquivo *.env*.

### 4. Execute a aplicação

Execute a App.
