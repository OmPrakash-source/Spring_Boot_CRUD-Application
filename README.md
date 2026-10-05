# Spring Boot CRUD Application

A professional Spring Boot application for managing student records using MySQL, JPA, and RESTful APIs.

## Overview

This repository demonstrates a clean and beginner-friendly CRUD implementation in Java using Spring Boot. It exposes REST endpoints to create, read, update, and delete student records stored in a MySQL database.

The application follows a standard layered architecture:
- Controller layer for REST endpoints
- Service layer for business logic
- Repository layer for database access
- Entity model for the data structure

## Features

- Create a new student record
- Fetch a single student by ID
- Retrieve all students
- Update an existing student record
- Delete a student by ID
- MySQL database integration using Spring Data JPA
- REST API design with JSON payloads

## Tech Stack

- Java 21
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- MySQL Connector/J
- Maven

## Project Structure

```text
Spring_Boot_CRUD-Application/
├── .mvn/
│   └── wrapper/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/crudSpring/
│   │   │       ├── controller/
│   │   │       │   └── StudentController.java
│   │   │       ├── entity/
│   │   │       │   └── Student.java
│   │   │       ├── repository/
│   │   │       │   └── StudentRepository.java
│   │   │       ├── service/
│   │   │       │   └── StudentService.java
│   │   │       └── CrudSpringApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/example/crudSpring/
│           └── CrudSpringApplicationTests.java
├── .gitattributes
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Architecture

The application is organized into the following components:

- `controller` – Handles incoming HTTP requests
- `service` – Executes business logic and validation
- `repository` – Interacts with the database using JPA
- `entity` – Defines the `Student` model mapped to a database table

## Entity Model

The `Student` entity includes:

- `id`
- `name`
- `age`
- `gmail`
- `rollNo`
- `subject`

## API Endpoints

Base URL: `http://localhost:8080`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/student` | Create a student |
| `GET` | `/api/student/{id}` | Get student by ID |
| `GET` | `/api/student/getAll` | Get all students |
| `PUT` | `/api/student/{id}` | Update a student |
| `DELETE` | `/api/student/{id}` | Delete a student |

## Example Request

### Create Student

```http
POST /api/student
Content-Type: application/json
```

```json
{
  "name": "John Doe",
  "age": 21,
  "gmail": "john.doe@example.com",
  "rollNo": 101,
  "subject": "Computer Science"
}
```

## Database Configuration

The project uses MySQL and is configured in `src/main/resources/application.properties`:

```properties
spring.application.name=crudSpring

spring.datasource.url=jdbc:mysql://localhost:3306/student_crud_db
spring.datasource.username=root
spring.datasource.password=2005
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Before running the application:

1. Install and start MySQL.
2. Create a database named `student_crud_db`.
3. Update database credentials if needed.

## Prerequisites

- Java 21+
- Maven
- MySQL Server
- IDE such as IntelliJ IDEA or VS Code (optional)

## Running the Application

### Using Maven Wrapper

```bash
./mvnw clean install
./mvnw spring-boot:run
```

### On Windows

```bash
mvnw.cmd clean install
mvnw.cmd spring-boot:run
```

After the application starts successfully, the REST API will be available on:

```text
http://localhost:8080
```

## Testing

The project contains a basic application test class under:

```text
src/test/java/com/example/crudSpring/CrudSpringApplicationTests.java
```

Run tests with:

```bash
./mvnw test
```

## Notes

This project is designed as a learning-focused CRUD application to help understand:

- Spring Boot application structure
- REST API development
- JPA entity mapping
- MySQL integration
- Service and repository layering

## License

This project is intended for educational and learning purposes.

## Author

Om Prakash

## Contributing

Contributions are welcome. If you want to improve the project, feel free to open a pull request or suggest enhancements.
