# Spring Boot – Multiple Database Example (MySQL + PostgreSQL)

This is a sample Spring Boot application that demonstrates how to connect to **multiple databases** using **JPA**, with **MySQL** and **PostgreSQL** as examples.

It shows how to configure separate `DataSource`, `EntityManager`, and `TransactionManager` for each database, and how to route your repositories accordingly.

---

## 📌 Features

* Multiple database support using Spring Data JPA
* Configuration for both **MySQL** and **PostgreSQL**
* Independent transaction managers for each database
* Clean separation of entity and repository layers for each DB
* Uses `@EnableJpaRepositories` with base packages
* Property-driven DB connection using `application.properties`

---

## 🏗 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.example/
│   │       ├── config/
│   │       │   ├── MySQLConfig.java
│   │       │   └── PostgresConfig.java
│   │       ├── mysql/
│   │       │   ├── entity/
│   │       │   └── repository/
│   │       └── postgres/
│   │           ├── entity/
│   │           └── repository/
│   └── resources/
│       └── application.properties
```

---

## ⚙️ Configuration

### 🔹 `application.properties`

Define connection strings for both databases:

```properties
# MySQL
mysql.datasource.url=jdbc:mysql://localhost:3306/mysql_db
mysql.datasource.username=root
mysql.datasource.password=your_password

# PostgreSQL
postgres.datasource.url=jdbc:postgresql://localhost:5432/postgres_db
postgres.datasource.username=postgres
postgres.datasource.password=your_password
```

### 🔹 Configuration Classes

Each DB has its own config class that defines:

* `DataSource` Bean
* `EntityManagerFactory` Bean
* `TransactionManager` Bean
* `@EnableJpaRepositories` for DB-specific package

Example:

```java
@EnableJpaRepositories(
    basePackages = "com.example.mysql.repository",
    entityManagerFactoryRef = "mysqlEntityManager",
    transactionManagerRef = "mysqlTransactionManager"
)
```

---

## 🗃 Repositories & Entities

* Entities and repositories for MySQL are kept under `com.example.mysql`
* Entities and repositories for PostgreSQL are kept under `com.example.postgres`

This separation helps Spring Boot know which configuration to use for each DB.

---

## ▶️ Running the App

1. Clone the repository
   `git clone https://github.com/sandeepjak2007/SpringBoot-Multiple-DB.git`

2. Set your DB credentials in `application.properties`

3. Start your MySQL and PostgreSQL servers

4. Run the application using:

```bash
./mvnw spring-boot:run
```

or from your IDE.

---

## 📄 License

This project is licensed under the MIT License.

---

Let me know if you want to add sample endpoints, test cases, or a video demo link.
