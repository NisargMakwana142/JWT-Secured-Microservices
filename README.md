# JWT Secured Microservices – Spring Boot

## 📌 Project Overview

This project demonstrates a **JWT-secured microservices architecture** built using **Spring Boot** and **Spring Cloud**.  
It consists of multiple independent services that communicate with each other through a **Cloud API Gateway** and are registered with a **Service Registry (Eureka Server)**.

The system manages **School** and **Student** data, while ensuring secure access to APIs using **JWT-based authentication and authorization**.

Key goals of this project:
- Understand real-world **microservices architecture**
- Implement **JWT security** in a distributed system
- Use **API Gateway** for centralized routing and security
- Follow **clean layered architecture** (Controller → Service → Repository)

---

## 🛠 Tech Stack

- **Java 21**
- **Spring Boot**
- **Spring Cloud**
  - Eureka Server (Service Registry)
  - Spring Cloud Gateway
  - OpenFeign (Inter-service communication)
- **Spring Security**
- **JWT (JSON Web Token)**
- **Spring Data JPA**
- **SQLYOG**
- **Maven**
- **Postman**

---

## 🚀 How to Use This Repository

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/NisargMakwana142/JWT-Secured-Microservices.git
cd JWT-Secured-Microservices
```

---

### 2️⃣ Start Services (Order Matters)

| Service | Port |
|------|------|
| Eureka Server (Service Registry) | **8761** |
| Cloud API Gateway | **8083** |
| School Service | **8081** |
| Student Service | **8082** |

#### Step-by-step startup:

```bash
# 1. Start Eureka Server
cd eureka-server
mvn spring-boot:run
```

```bash
# 2. Start API Gateway
cd api-gateway
mvn spring-boot:run
```

```bash
# 3. Start School Service
cd school-service
mvn spring-boot:run
```

```bash
# 4. Start Student Service
cd student-service
mvn spring-boot:run
```

📌 Eureka Dashboard:  
`http://localhost:8761`

---

## ⚙ Configuration Templates

### 🔹 API Gateway – `application.yml` (Template)

```yaml
server:
  port: 8083

spring:
  application:
    name: API-GATEWAY

  cloud:
    gateway:
      routes:
        - id: SCHOOL-SERVICE
          uri: lb://SCHOOL-SERVICE
          predicates:
            - Path=/api/schools/**

        - id: STUDENT-SERVICE
          uri: lb://STUDENT-SERVICE
          predicates:
            - Path=/api/students/**

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

---

### 🔹 School / Student Service – `application.properties` (Template)

```properties
server.port=8081   # change to 8082 for student service

spring.application.name=SCHOOL-SERVICE

spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```



---

## 🧪 Testing Endpoints Using Postman

You can test all secured and unsecured endpoints using **Postman**.

### Steps:

1. Open **Postman**
2. Create a new request
3. Use the **API Gateway base URL**:
   ```
   http://localhost:8083
   ```

4. For secured endpoints:
   - First authenticate (login endpoint) to get the **JWT token**
   - Copy the token from the response
   - Go to **Authorization → Bearer Token**
   - Paste the JWT token

5. Now access secured APIs such as:
   - `GET /api/schools`
   - `POST /api/schools`
   - `GET /api/students`
   - `POST /api/students`

📌 All requests should go through the **API Gateway**, not directly to individual services.

---

## 🔐 Security Used

- **Spring Security**
- **JWT (JSON Web Token)** authentication
- Stateless authentication (no sessions)
- Token-based authorization for protected APIs
- JWT validation applied at **API Gateway**
- Secured endpoints for School and Student services

### Security Flow
1. User authenticates → JWT token generated  
2. Client sends token with every request  
3. API Gateway validates JWT  
4. Request forwarded to respective microservice  

---

## 🧱 Architecture Used

### Model–Controller–Service–Repository Pattern

Each microservice follows a clean layered architecture:

```
Controller
   ↓
Service
   ↓
Repository
   ↓
Database
```

### Layer Responsibilities

- **Controller**
  - Handles HTTP requests
  - Exposes REST APIs
  - No business logic

- **Service**
  - Contains business logic
  - Communicates with other services if required

- **Repository**
  - Handles database operations
  - Uses Spring Data JPA

- **Model (Entity)**
  - Represents database tables
  - Annotated with JPA annotations

---

## 🧩 Overall Architecture Diagram (Conceptual)

```
Client
   ↓
API Gateway (JWT Security)
   ↓
Eureka Service Registry
   ↓
├── School Service → SQLYOG
└── Student Service → SQLYOG
```

---

## 👤 Author

**Nisarg Makwana**  
GitHub: [@NisargMakwana142](https://github.com/NisargMakwana142)

Email: nisarg.makwana204@gmail.com

