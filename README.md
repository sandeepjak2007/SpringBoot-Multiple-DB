# SpringBoot-Multiple-DB

SpringBoot-Multiple-DB is a sample Spring Boot application demonstrating how to connect and interact with multiple databases within a single Spring Boot project[1]. This setup is useful for scenarios such as microservices, legacy integration, or when different data domains require separate storage solutions[6].

## Features

- Connects to multiple databases from a single Spring Boot application
- Supports configuration of separate DataSources, EntityManagers, and TransactionManagers
- Example configuration for relational databases (e.g., MySQL, PostgreSQL)
- Demonstrates best practices for data segregation and scalability

## Table of Contents

- Overview
- Prerequisites
- Getting Started
- Configuration
- Usage
- Project Structure
- Contributing

## Overview

This project provides a template for configuring multiple database connections in a Spring Boot application. It is ideal for developers who need to integrate with more than one database, such as combining legacy and new systems, or optimizing for different types of data storage[6].

## Prerequisites

- Java 8 or higher
- Maven or Gradle
- Spring Boot (version as specified in the project)
- Access to at least two relational databases (e.g., MySQL, PostgreSQL)

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/sandeepjak2007/SpringBoot-Multiple-DB.git
   cd SpringBoot-Multiple-DB
   ```

2. **Configure your database connections:**  
   Update your `application.properties` or `application.yml` with the connection details for each database. For example[3]:

   ```
   database1.datasource.url=jdbc:mysql://localhost:3306/db1
   database1.datasource.username=user1
   database1.datasource.password=pass1
   database1.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   database2.datasource.url=jdbc:postgresql://localhost:5432/db2
   database2.datasource.username=user2
   database2.datasource.password=pass2
   database2.datasource.driver-class-name=org.postgresql.Driver
   ```

3. **Build and run the application:**
   ```bash
   mvn spring-boot:run
   ```
   or
   ```bash
   ./gradlew bootRun
   ```

## Configuration

- **DataSource Beans:**  
  Define a `@Bean` for each DataSource, using `@ConfigurationProperties` to bind configuration properties[3].
- **EntityManager and TransactionManager:**  
  For JPA, configure a separate `EntityManagerFactory` and `PlatformTransactionManager` for each DataSource[7].
- **Repositories:**  
  Use `@EnableJpaRepositories` with `basePackages`, `entityManagerFactoryRef`, and `transactionManagerRef` to link repositories to the correct DataSource[7].

## Usage

- Use the configured repositories as you would in any Spring Data JPA project.
- Each repository will interact with its designated database, allowing you to manage data across multiple sources seamlessly.

## Project Structure

- `src/main/java/.../config/`  
  Contains DataSource, EntityManager, and TransactionManager configuration classes.
- `src/main/java/.../repository/`  
  Contains repository interfaces for each database.
- `src/main/resources/application.properties`  
  Database connection properties.


[1] https://github.com/sandeepjak2007/SpringBoot-Multiple-DB
[2] https://github.com/jahe/spring-boot-multiple-datasources
[3] https://stackoverflow.com/questions/30337582/spring-boot-configure-and-use-two-data-sources
[4] https://docs.github.com/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-readmes
[5] https://github.com/JavatoDev-com/spring-boot-multiple-datasources/blob/main/README.md
[6] https://dev.to/javafullstackdev/a-comprehensive-guide-to-multiple-database-configuration-for-microservices-in-spring-boot-1la4
[7] https://www.youtube.com/watch?v=z65J3JPbs9A
[8] https://github.com/mouhamed-ali/spring-boot-multiple-datasources
[9] https://github.com/keramiozsoy/spring-boot-multiple-db