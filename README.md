# School & Student Management System - Microservices

A secure microservices-based application built with Spring Boot and Spring Cloud for managing school and student data with JWT authentication.

## 🚀 Features

- **Microservices Architecture** with independent Student and School services
- **JWT Authentication & Authorization** for secure API access
- **Service Discovery** using Eureka Server
- **API Gateway** for centralized routing and security
- **Inter-service Communication** via OpenFeign
- **Global Exception Handling** for consistent error responses
- **PostgreSQL** database integration with Spring Data JPA

## 🛠️ Tech Stack

- **Backend:** Java 21, Spring Boot 3.x, Spring Cloud
- **Security:** Spring Security, JWT
- **Database:** MySQL
- **Service Discovery:** Netflix Eureka
- **API Gateway:** Spring Cloud Gateway
- **Communication:** RestTemplate
- **Build Tool:** Maven
- **IDE:** Eclipse IDE

## 📦 Microservices

| Service | Port | Description |
|---------|------|-------------|
| **Eureka Server** | 8761 | Service discovery and registration |
| **API Gateway** | 8083 | Routes requests and handles authentication |
| **School Service** | 8081 | Manages school information |
| **Student Service** | 8082 | Manages student data and operations |

## 🏗️ Architecture
```
Client
  ↓
API Gateway (8083) ← JWT Authentication
  ↓
├─→ Student Service (8082) ←→ SQLYOG
├─→ School Service (8081) ←→ SQLYOG
  ↓
Eureka Server (8761) - Service Registry
```

## ⚙️ Prerequisites

Before running this project, ensure you have:

- **Java 21** or higher
- **Maven 3.5+**
- **SQLYOG**
- **Postman** (for testing APIs)

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/NisargMakwana142/school-student-microservices.git
cd school-student-microservices
```

### 2. Setup PostgreSQL Databases

Create two databases:
```sql
CREATE DATABASE student_db;
CREATE DATABASE school_db;
```

### 3. Configure Database

Update `application.properties` in each service:

**student-service/src/main/resources/application.properties:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

**school-service/src/main/resources/application.properties:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/school_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 4. Start Services (In Order)

**Terminal 1 - Start Eureka Server:**
```bash
cd eureka-server
mvn spring-boot:run
```
Wait for Eureka to start completely (check http://localhost:8761)

**Terminal 2 - Start School Service:**
```bash
cd school-service
mvn spring-boot:run
```

**Terminal 3 - Start Student Service:**
```bash
cd student-service
mvn spring-boot:run
```

**Terminal 4 - Start API Gateway:**
```bash
cd api-gateway
mvn spring-boot:run
```

### 5. Verify Services

- **Eureka Dashboard:** http://localhost:8761
- **API Gateway:** http://localhost:8080
- All services should be registered in Eureka

## 🔐 API Endpoints

### Authentication
```http
POST /auth/register - Register new user
POST /auth/login    - Login and get JWT token
```

### Student Endpoints (JWT Required)
```http
GET    /api/students       - Get all students
GET    /api/students/{id}  - Get student by ID
POST   /api/students       - Create new student
PUT    /api/students/{id}  - Update student
DELETE /api/students/{id}  - Delete student
```

### School Endpoints (JWT Required)
```http
GET    /api/schools       - Get all schools
GET    /api/schools/{id}  - Get school by ID
POST   /api/schools       - Create new school
PUT    /api/schools/{id}  - Update school
DELETE /api/schools/{id}  - Delete school
```

## 📝 API Usage Examples

### 1. Register User
```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "password123",
    "email": "test@example.com"
  }'
```

### 2. Login
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "password123"
  }'
```

Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer"
}
```

### 3. Get All Students (with JWT)
```bash
curl -X GET http://localhost:8080/api/students \
  -H "Authorization: Bearer YOUR_JWT_TOKEN"
```

### 4. Create Student
```bash
curl -X POST http://localhost:8080/api/students \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john@example.com",
    "schoolId": 1
  }'
```

## 🏗️ Project Structure
```
school-student-microservices/
├── eureka-server/              # Service Discovery
│   ├── src/
│   └── pom.xml
├── api-gateway/                # API Gateway & Security
│   ├── src/
│   └── pom.xml
├── school-service/             # School Management
│   ├── src/
│   └── pom.xml
├── student-service/            # Student Management
│   ├── src/
│   └── pom.xml
├── .gitignore
└── README.md
```

## 🔧 Technologies Deep Dive

### Spring Cloud Components
- **Eureka Server:** Dynamic service discovery and registration
- **API Gateway:** Centralized entry point, routing, and load balancing
- **OpenFeign:** Declarative REST client for inter-service communication

### Security
- **JWT (JSON Web Tokens):** Stateless authentication
- **Spring Security:** Role-based access control (RBAC)

### Database
- **Spring Data JPA:** Simplified database operations
- **Hibernate:** ORM for object-relational mapping
- **PostgreSQL:** Relational database management

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License.

## 👤 Author

**Nisarg Makwana**
- GitHub: [@NisargMakwana142](https://github.com/NisargMakwana142)
- LinkedIn: [Nisarg Makwana](https://linkedin.com/in/yourprofile)
- Email: your.email@example.com

## 🙏 Acknowledgments

- Spring Boot & Spring Cloud Documentation
- Tops Technology for training and guidance
- OpenFeign for simplified inter-service communication
