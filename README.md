# 📚 Library Management API

> REST API for complete library management — books, clients, employees and rentals.
> Built with Java, Spring Boot and PostgreSQL.

---

## 🇧🇷 Português | 🇺🇸 English

---

## 🇧🇷 Português

### Sobre o Projeto

API REST desenvolvida com **Java** e **Spring Boot** para gerenciamento completo de uma biblioteca. O sistema permite controlar o cadastro de livros, clientes e funcionários, além de gerenciar locações com controle de status e multa por atraso.

O projeto foi desenvolvido com **frontend integrado**, consumindo todos os endpoints da API.

### 🛠️ Tecnologias

- **Java** — linguagem principal
- **Spring Boot** — framework de aplicação
- **JPA / Hibernate** — mapeamento objeto-relacional
- **PostgreSQL** — banco de dados relacional
- **Maven** — gerenciamento de dependências

### 📐 Arquitetura

O projeto segue arquitetura em camadas:

```
entities/       → Entidades JPA (Book, Client, Employee, Rental)
repository/     → Interfaces JpaRepository com queries customizadas
restcontrollers/ → Controllers REST com endpoints HTTP
```

### 🗃️ Entidades e Relacionamentos

| Entidade | Descrição |
|---|---|
| `Book` | Livros com controle de quantidade e disponibilidade |
| `Client` | Clientes com busca por CPF |
| `Employee` | Funcionários responsáveis pelas locações |
| `Rental` | Locações com relacionamento ManyToMany (livros) e ManyToOne (cliente/funcionário) |

### 🔌 Endpoints

**Books** — `GET/POST/DELETE /apis/book`
| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/apis/book/add` | Cadastrar livro |
| GET | `/apis/book/find-all` | Listar todos os livros |
| GET | `/apis/book/find-all-genres` | Listar gêneros distintos |
| DELETE | `/apis/book/delete` | Remover livro por ID |

**Clients** — `GET/POST/DELETE /apis/client`
| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/apis/client/add` | Cadastrar cliente |
| GET | `/apis/client/find-all` | Listar todos os clientes |
| GET | `/apis/client/find-cpf?cpf=` | Buscar cliente por CPF |
| GET | `/apis/client/find-rentals-cpf?cpf=` | Buscar locações por CPF |
| DELETE | `/apis/client/delete` | Remover cliente por ID |

**Employees** — `GET/POST/DELETE /apis/employee`
| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/apis/employee/add` | Cadastrar funcionário |
| GET | `/apis/employee/find-all` | Listar todos os funcionários |
| DELETE | `/apis/employee/delete` | Remover funcionário por ID |

**Rentals** — `GET/POST/PUT/DELETE /apis/rental`
| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/apis/rental/add` | Criar locação |
| GET | `/apis/rental/find-all` | Listar todas as locações |
| PUT | `/apis/rental/confirm-payment` | Confirmar pagamento e finalizar locação |
| DELETE | `/apis/rental/delete` | Remover locação por ID |

### ▶️ Como Rodar

**Pré-requisitos:**
- Java 17+
- Maven
- PostgreSQL

**1. Clone o repositório**
```bash
git clone https://github.com/Zoratoo/api-LibraryApp.git
cd api-LibraryApp
```

**2. Configure o banco de dados**

Crie um banco no PostgreSQL:
```sql
CREATE DATABASE library_db;
```

**3. Configure o `application.properties`**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**4. Execute o projeto**
```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`

---

## 🇺🇸 English

### About

REST API built with **Java** and **Spring Boot** for complete library management. The system handles book, client and employee registration, as well as rental management with status control and late fee tracking.

The project includes an **integrated frontend** that consumes all API endpoints.

### 🛠️ Tech Stack

- **Java** — main language
- **Spring Boot** — application framework
- **JPA / Hibernate** — object-relational mapping
- **PostgreSQL** — relational database
- **Maven** — dependency management

### 📐 Architecture

The project follows a layered architecture:

```
entities/        → JPA Entities (Book, Client, Employee, Rental)
repository/      → JpaRepository interfaces with custom queries
restcontrollers/ → REST Controllers with HTTP endpoints
```

### 🗃️ Entities & Relationships

| Entity | Description |
|---|---|
| `Book` | Books with quantity and availability control |
| `Client` | Clients with CPF (tax ID) lookup |
| `Employee` | Employees responsible for rentals |
| `Rental` | Rentals with ManyToMany (books) and ManyToOne (client/employee) relationships |

### 🔌 Endpoints

**Books** — `GET/POST/DELETE /apis/book`
| Method | Endpoint | Description |
|---|---|---|
| POST | `/apis/book/add` | Add a book |
| GET | `/apis/book/find-all` | List all books |
| GET | `/apis/book/find-all-genres` | List distinct genres |
| DELETE | `/apis/book/delete` | Remove book by ID |

**Clients** — `GET/POST/DELETE /apis/client`
| Method | Endpoint | Description |
|---|---|---|
| POST | `/apis/client/add` | Add a client |
| GET | `/apis/client/find-all` | List all clients |
| GET | `/apis/client/find-cpf?cpf=` | Find client by CPF |
| GET | `/apis/client/find-rentals-cpf?cpf=` | Find rentals by client CPF |
| DELETE | `/apis/client/delete` | Remove client by ID |

**Employees** — `GET/POST/DELETE /apis/employee`
| Method | Endpoint | Description |
|---|---|---|
| POST | `/apis/employee/add` | Add an employee |
| GET | `/apis/employee/find-all` | List all employees |
| DELETE | `/apis/employee/delete` | Remove employee by ID |

**Rentals** — `GET/POST/PUT/DELETE /apis/rental`
| Method | Endpoint | Description |
|---|---|---|
| POST | `/apis/rental/add` | Create a rental |
| GET | `/apis/rental/find-all` | List all rentals |
| PUT | `/apis/rental/confirm-payment` | Confirm payment and close rental |
| DELETE | `/apis/rental/delete` | Remove rental by ID |

### ▶️ How to Run

**Prerequisites:**
- Java 17+
- Maven
- PostgreSQL

**1. Clone the repository**
```bash
git clone https://github.com/Zoratoo/api-LibraryApp.git
cd api-LibraryApp
```

**2. Set up the database**

Create a database in PostgreSQL:
```sql
CREATE DATABASE library_db;
```

**3. Configure `application.properties`**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**4. Run the project**
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

---

## 👨‍💻 Author

**Guilherme Zorato Vernilo**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Guilherme_Zorato-0077B5?style=flat&logo=linkedin)](https://linkedin.com/in/guilherme-zorato)
[![GitHub](https://img.shields.io/badge/GitHub-Zoratoo-181717?style=flat&logo=github)](https://github.com/Zoratoo)
