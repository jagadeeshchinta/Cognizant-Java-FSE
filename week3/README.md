# Week 3 - Spring Boot, REST, and JWT Exercises

> All exercises use the project: **com.cognizant / spring-learn**
> Each folder is a complete, buildable snapshot of the project at that stage.

---

## 📁 Project Structure

```
week3/
├── Exercise1_SpringBootProject/    ← Basic Spring Boot Web app setup
├── Exercise2_SpringXMLConfig/      ← Spring XML bean config + Country class
├── Exercise3_RESTServices/         ← Hello World + Country REST + MockMVC tests
└── Exercise4_JWTAuth/              ← Spring Security + JWT token generation
```

---

## Exercise 1 — Spring Boot Web Project

📁 `Exercise1_SpringBootProject/`  
**Port**: `8083`

**Key Concepts**: `@SpringBootApplication`, `SpringApplication.run()`, embedded Tomcat, DevTools, SLF4J logging

**Project Structure walkthrough**:
| Folder | Purpose |
|---|---|
| `src/main/java` | Application source code |
| `src/main/resources` | Configuration (application.properties) |
| `src/test/java` | Test code |

**Run**:
```bash
cd Exercise1_SpringBootProject
mvn spring-boot:run
```

---

## Exercise 2 — Spring Core: Load Country from XML

📁 `Exercise2_SpringXMLConfig/`  
**Port**: `8083`

**Key Concepts**: `ClassPathXmlApplicationContext`, `ApplicationContext`, `context.getBean()`,  
`<bean>`, `<property>`, singleton scope, debug logging in constructor/getters/setters

**Key Files**:
| File | Purpose |
|---|---|
| `country.xml` | Spring XML with 4 country beans (US, DE, IN, JP) |
| `Country.java` | Domain class with debug logs in constructor + setters/getters |
| `SpringLearnApplication.java` | Calls `displayCountry()` which loads India from XML |

**Expected Log Output** (when you run the app):
```
Inside Country Constructor.
Inside setCode(). Setting code = IN
Inside setName(). Setting name = India
Country : Country{code='IN', name='India'}
```

---

## Exercise 3 — RESTful Web Services

📁 `Exercise3_RESTServices/`  
**Port**: `8083`

**Key Concepts**: `@RestController`, `@GetMapping`, `@RequestMapping`, `@PathVariable`,  
JSON serialization (Jackson), `MockMvc`, `jsonPath()`, `andExpect()`

### REST Endpoints

| Method | URL | Description | Response |
|---|---|---|---|
| GET | `/hello` | Hello World | `Hello World!!` |
| GET | `/country` | India details | `{"code":"IN","name":"India"}` |
| GET | `/countries/{code}` | Country by code (case-insensitive) | Country JSON or 400 |

### Sample Requests
```
http://localhost:8083/hello
http://localhost:8083/country
http://localhost:8083/countries/in
http://localhost:8083/countries/US
http://localhost:8083/countries/de
```

### Run Tests (MockMVC)
```bash
mvn test
```

---

## Exercise 4 — JWT Authentication

📁 `Exercise4_JWTAuth/`  
**Port**: `8090`

**Key Concepts**: Spring Security, HTTP Basic Auth, Base64 encoding/decoding,  
JWT structure (Header.Payload.Signature), `jjwt` library, `@EnableWebSecurity`,  
`AuthenticationManagerBuilder`, `antMatchers`, JWT token generation

### Key Files

| File | Purpose |
|---|---|
| `SecurityConfig.java` | In-memory auth, URL rules, BCrypt encoder |
| `JwtUtil.java` | JWT token generation (HS256 signing) |
| `AuthController.java` | GET /authenticate → reads Basic Auth, returns JWT |

### Credentials
```
username: user
password: pwd
```

### JWT Process Flow
```
Client ──Basic Auth──→ GET /authenticate ──→ Server authenticates
                                         ──→ JwtUtil.generateToken("user")
                                         ──→ Returns {"token":"eyJ..."}
Client ──Bearer token──→ GET /country ──→ Server validates JWT
                                      ──→ Returns country JSON
```

### Test Authentication (curl)
```bash
curl -s -u user:pwd http://localhost:8090/authenticate
```

**Expected Response**:
```json
{"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNTcwMzc5NDc0LCJleHAiOjE1NzAzODA2NzR9.t3LRvlCV-hwKfoqZYlaVQqEUiBloWcWn0ft3tgv0dL0"}
```

### JWT Token Structure
```
Header  : {"alg":"HS256","typ":"JWT"}           → Base64 encoded
Payload : {"sub":"user","iat":...,"exp":...}    → Base64 encoded
Signature: HMACSHA256(header.payload, secret)   → Base64 encoded
```

### Run Application
```bash
cd Exercise4_JWTAuth
mvn spring-boot:run
```

---

## How to Run Any Exercise in Eclipse/IntelliJ

1. `File → Import → Maven → Existing Maven Projects`
2. Browse to the exercise folder (e.g., `Exercise3_RESTServices`)
3. Click **Finish** and wait for dependencies to download
4. Right-click `SpringLearnApplication.java` → **Run As → Spring Boot App**

## How to Build from Command Line
```bash
cd <exercise-folder>
mvn clean package
java -jar target/spring-learn-0.0.1-SNAPSHOT.jar
```
