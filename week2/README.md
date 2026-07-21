# Week 2 - Spring Framework Exercises

> Library Management Application — Spring Core, IoC/DI, Maven, and Spring Boot

---

## 📁 Project Structure

```
week2/
├── Exercise1_BasicSpring/                ← Basic Spring Core application
├── Exercise2_DependencyInjection/        ← Setter-based Dependency Injection
├── Exercise4_MavenProject/               ← Maven project with Spring dependencies
├── Exercise5_IoCContainer/               ← Spring IoC container configuration
├── Exercise7_ConstructorSetterInjection/ ← Constructor + Setter injection
└── Exercise9_SpringBoot/                 ← Spring Boot REST API with H2 + JPA
```

---

## Exercise 1 — Configuring a Basic Spring Application

**Concepts**: Spring Core, ApplicationContext, XML Bean Configuration  
**Tech**: Spring 5.3.x, Maven

| File | Purpose |
|---|---|
| `pom.xml` | Spring Core, Beans, Context dependencies |
| `applicationContext.xml` | Defines `bookService` and `bookRepository` beans |
| `BookRepository.java` | Data access layer bean |
| `BookService.java` | Service layer bean |
| `LibraryManagementApplication.java` | Loads context, retrieves and tests beans |

**Run**: Open in IDE → Run `LibraryManagementApplication.main()`

---

## Exercise 2 — Implementing Dependency Injection

**Concepts**: Spring IoC, Setter Injection, Bean Wiring  
**Tech**: Spring 5.3.x, Maven

| File | Key Change |
|---|---|
| `applicationContext.xml` | `<property name="bookRepository" ref="bookRepository"/>` wires DI |
| `BookService.java` | Added `setBookRepository()` setter for DI |

**What to observe**: Spring calls `setBookRepository()` automatically at startup.

---

## Exercise 4 — Creating and Configuring a Maven Project

**Concepts**: Maven project structure, Spring dependency management  
**Tech**: Maven 3.x, Spring 5.3.x

| Dependency | Purpose |
|---|---|
| `spring-context` | Spring IoC container and ApplicationContext |
| `spring-aop` | Aspect-Oriented Programming |
| `spring-webmvc` | Spring MVC web framework |

**Maven Compiler Plugin** configured to target **Java 1.8**.

---

## Exercise 5 — Configuring the Spring IoC Container

**Concepts**: Central Spring configuration, Bean lifecycle, Setter Injection  
**Tech**: Spring 5.3.x, XML-based configuration

The `applicationContext.xml` serves as the **central IoC configuration** defining:
- `bookRepository` bean (data layer)
- `bookService` bean with `bookRepository` property injected

---

## Exercise 7 — Constructor and Setter Injection

**Concepts**: Constructor Injection vs Setter Injection  
**Tech**: Spring 5.3.x

| Injection Type | XML Tag | Java |
|---|---|---|
| Constructor | `<constructor-arg ref="bookRepository"/>` | `BookService(BookRepository repo)` |
| Setter | `<property name="libraryName" value="..."/>` | `setLibraryName(String name)` |

**When to use**:
- **Constructor injection** → Mandatory dependencies (object cannot work without it)
- **Setter injection** → Optional/reconfigurable dependencies

---

## Exercise 9 — Spring Boot Application

**Concepts**: Spring Boot, REST API, JPA, H2 database, Auto-configuration  
**Tech**: Spring Boot 2.7.x, Spring Web, Spring Data JPA, H2

### Project Structure
```
Exercise9_SpringBoot/
├── src/main/java/com/library/
│   ├── LibraryManagementApplication.java   ← @SpringBootApplication entry point
│   ├── model/Book.java                      ← @Entity mapped to 'books' table
│   ├── repository/BookRepository.java       ← JpaRepository<Book, Long>
│   ├── service/BookService.java             ← Business logic layer
│   ├── controller/BookController.java       ← REST Controller (@RestController)
│   └── config/DataInitializer.java          ← Loads sample data on startup
├── src/main/resources/
│   └── application.properties               ← H2 + JPA configuration
└── src/test/java/com/library/
    └── LibraryManagementApplicationTests.java ← Integration tests
```

### REST API Endpoints

| Method | URL | Description |
|---|---|---|
| `GET` | `/api/books` | Get all books |
| `GET` | `/api/books/{id}` | Get book by ID |
| `GET` | `/api/books/search?title=keyword` | Search books by title |
| `GET` | `/api/books/author/{author}` | Get books by author |
| `POST` | `/api/books` | Create a new book |
| `PUT` | `/api/books/{id}` | Update a book |
| `DELETE` | `/api/books/{id}` | Delete a book |

### How to Run
```bash
cd Exercise9_SpringBoot
mvn spring-boot:run
```

Then visit:
- **API**: http://localhost:8080/api/books
- **H2 Console**: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:librarydb`)

### Sample POST Request (Create a Book)
```json
POST http://localhost:8080/api/books
Content-Type: application/json

{
  "title": "Spring Boot in Practice",
  "author": "Somnath Musib",
  "isbn": "978-1617298813",
  "publicationYear": 2022,
  "price": 47.99
}
```

---

## 🚀 How to Run Each Exercise (Exercises 1, 2, 5, 7)

### Prerequisites
- Java 8+
- Maven 3.6+

### Steps
```bash
cd Exercise1_BasicSpring     # (or Exercise2, Exercise5, Exercise7)
mvn clean compile
mvn exec:java -Dexec.mainClass="com.library.LibraryManagementApplication"
```

Or simply open in **IntelliJ IDEA** / **Eclipse** and run `LibraryManagementApplication.java`.
