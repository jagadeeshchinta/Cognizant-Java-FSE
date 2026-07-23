# Week 4 - Microservices for Bank Management (Accounts & Loans)

This directory contains the microservices developed as part of Week 4 hands-on exercises.

---

## 📁 Project Structure

```
week4/
├── account/                 ← Account Microservice (Port 8080)
├── loan/                    ← Loan Microservice (Port 8081)
├── eureka-discovery-server/ ← Eureka Discovery Server (Port 8761)
├── greet-service/           ← Greet Microservice (Port 8082)
└── api-gateway/             ← Spring Cloud API Gateway (Port 9090)
```

---

## 🚀 Services Overview

| Microservice | Port | App Name | Key Endpoint | Sample Output |
|---|---|---|---|---|
| **Eureka Server** | `8761` | `eureka-discovery-server` | `http://localhost:8761` | Service Registry Dashboard |
| **Account Service** | `8080` | `account-service` | `GET /accounts/{number}` | `{"number":"00987987973432","type":"savings","balance":234343.0}` |
| **Loan Service** | `8081` | `loan-service` | `GET /loans/{number}` | `{"number":"H00987987972342","type":"car","loan":400000.0,"emi":3258.0,"tenure":18}` |
| **Greet Service** | `8082` | `greet-service` | `GET /greet` | `"Hello World!!"` |
| **API Gateway** | `9090` | `api-gateway` | `GET /greet-service/greet` | Via Gateway: `"Hello World!!"` |
| | | | `GET /account-service/accounts/{number}` | Via Gateway: Account Details |
| | | | `GET /loan-service/loans/{number}` | Via Gateway: Loan Details |

---

## ⚙️ How to Run the Microservices

1. **Start Eureka Server** (Port `8761`):
   ```bash
   cd eureka-discovery-server
   mvn spring-boot:run
   ```
   Open `http://localhost:8761` in browser to check the Eureka dashboard.

2. **Start Microservices**:
   - **Account Service**:
     ```bash
     cd account
     mvn spring-boot:run
     ```
   - **Loan Service**:
     ```bash
     cd loan
     mvn spring-boot:run
     ```
   - **Greet Service**:
     ```bash
     cd greet-service
     mvn spring-boot:run
     ```

3. **Start API Gateway** (Port `9090`):
   ```bash
   cd api-gateway
   mvn spring-boot:run
   ```

---

## 🧪 Testing Gateway Routing & Global Filter

Access services through the API Gateway at port **9090**:
- `http://localhost:9090/greet-service/greet`
- `http://localhost:9090/account-service/accounts/00987987973432`
- `http://localhost:9090/loan-service/loans/H00987987972342`

Check the `api-gateway` terminal console to see the request URI logged by `LogFilter`:
```
INFO ====>Request URL http://localhost:9090/greet-service/greet
```
