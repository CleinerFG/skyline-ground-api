# Skyline Ground API 🏢

Real estate management system for controlling projects, constructions, assets, and finances, integrating inventory,
contracts, and centralized auditing for administrators.

## Languages

- [Portuguese-BR](README.pt.md)

## Technologies Used

The project was developed using **Java 17** and **Spring Boot 3.5.11**.

- **Framework**: Spring Boot (Web, Data JPA, Security, Validation)
- **Database**: PostgreSQL
- **Migration Management**: Flyway
- **Security**: Java-JWT
- **Utilities**: Lombok
- **Containerization**: Docker

## Prerequisites

Before you begin, you will need to have installed on your machine:

- [Git](https://git-scm.com)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Docker](https://www.docker.com/)

## Installation and Execution

### 1. Clone the repository

```bash
git clone [https://github.com/CleinerFG/skyline-ground-api.git](https://github.com/CleinerFG/skyline-ground-api.git)
cd skyline-ground-api
```

### 2. Start the database with Docker

```bash
docker-compose up -d
```

### 3. Configure environment variables

- Create a `.env` file in the root of the project and
  configure the access credentials for the database and the application.

Example:

```bash
DB_POSTGRES_USERNAME=username
DB_POSTGRES_PASSWORD=password
DB_POSTGRES_URL=jdbc:postgresql://localhost:5432/skyline-ground
JWT_SECRET=jwt-secret-hash
JWT_ISSUER=skyline-ground
JWT_EXPIRATION_SECONDS=3600
ADMIN_NAME=my-admin
ADMIN_EMAIL=admin@system.com
ADMIN_PASSWORD=admin
```

- Config your IDE to use environment variables.

Config IntelliJ IDEA:

```bash
Run > Edit Configurations > Add New Configuration > Aplication
```

Fill:

- `Name`: Skyline Ground App
- `Main Class`: com.skylineground.SkylineGroundApplication
- `Environment variables`: ../skyline-ground-api/.env

`Note`: In the *Environment variables*, put the full path to the *.env* file.

### 4. Run the application

Execute the App.
