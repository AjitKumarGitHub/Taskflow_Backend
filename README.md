#  TaskFlow – Scalable Backend System with Authentication & RBAC

A production-structured full-stack backend system built using **Spring Boot, MongoDB, JWT Authentication**, and a modern frontend built with **Next.js + Tailwind CSS**.

This project demonstrates strong backend engineering principles including **secure authentication, role-based access control, modular architecture, and scalable API design**.

---

## 🌐 Live Demo

🔗 Frontend Application:  
[TaskFlow Frontend Live Demo](https://taskflow-frontend-five-sage.vercel.app/)

---

##  Key Highlights

-  Secure JWT Authentication
-  Role-Based Access Control (USER / ADMIN)
-  Modular and Scalable Spring Boot Architecture
-  MongoDB Atlas Integration
-  RESTful API Design  
-  Swagger API Documentation
-  Full CRUD Operations
-  Responsive Frontend (Next.js + Tailwind)
-  Production-ready Deployment (Vercel + Atlas)

---

##  System Architecture
Frontend (Next.js)
↓
REST APIs (Spring Boot)
↓
Service Layer (Business Logic)
↓
Repository Layer
↓
MongoDB Atlas (Database)


---

##  Tech Stack

### Backend
- Java 17
- Spring Boot 3
- Spring Security
- JWT Authentication
- MongoDB Atlas
- Maven

### Frontend
- Next.js 14
- React.js
- Tailwind CSS
- Axios
- React Hot Toast

### Tools & Deployment
- Swagger / OpenAPI
- Postman
- Vercel
- MongoDB Atlas

---

##  Project Structure

### Backend
 taskflow-backend/
├── src/main/java/com/taskflow
│   ├── TaskflowApplication.java
│   ├── config
│   │   ├── SwaggerConfig.java
│   │   └── SecurityConfig.java
│   ├── controller
│   │   ├── AuthController.java
│   │   ├── TaskController.java
│   │   └── AdminController.java
│   ├── pojo
│   │     |
│   │     ├── LoginRequest.java
│   │     ├── RegisterRequest.java
│   │     └── TaskRequest.java
│   │   
│   │     ├── ApiResponse.java
│   │     ├── AuthResponse.java
│   │     └── TaskResponse.java
│   ├── entity
│   │   ├── Role.java
│   │   ├── User.java
│   │   └── Task.java
│   ├── exception
│   │   ├── GlobalExceptionHandler.java
│   │   ├── ResourceNotFoundException.java
│   │   └── UnauthorizedException.java
│   ├── repository
│   │   ├── UserRepository.java
│   │   └── TaskRepository.java
│   ├── security
│   │   ├── JwtAuthFilter.java
│   │   ├── JwtService.java
│   │   └── CustomUserDetailsService.java
│   ├── service
│   │   ├── AuthService.java
│   │   ├── TaskService.java
│   │   └── AdminService.java
│   └── util
│       └── MapperUtil.java
├── src/main/resources
│   └── application.yml
├── pom.xml
└── README.md

---


---

##  Authentication Flow

1. User registers → password hashed using BCrypt  
2. Login generates JWT token  
3. Token stored in frontend (localStorage)  
4. Token sent in Authorization header  
5. Backend validates token via filter  
6. Role-based access enforced (USER / ADMIN)

---

##  API Endpoints

###  Auth APIs

#### Register
```http
POST /api/v1/auth/register // register Admin
{
  "name": "Ajit Kumar",
  "email": "ajitadmin@gmail.com",
  "password": "123456",
  "role": "ADMIN"
}
or for user register
{
  "name": "Ajit Kumar",
  "email": "ajituser@gmail.com",
  "password": "123456",
  "role": "USER"
}
## Authorization Rules
Role	Access Level
USER	Manage own tasks
ADMIN	Full system access
# 📡 API Endpoints

##  Authentication APIs

| Method | Endpoint | Description | Access |
|--------|-----------|-------------|---------|
| POST | `/api/v1/auth/register` | Register new user/admin | Public |
| POST | `/api/v1/auth/login` | Login user/admin | Public |

---

TaskFlow Backend API
│
├── Auth APIs
│   ├── Register User
│   ├── Register Admin
│   ├── Login User
│   └── Login Admin
│
├── User Task APIs
│   ├── Create Task
│   ├── Get All Tasks
│   ├── Get Task By ID
│   ├── Update Task
│   └── Delete Task
│
└── Admin APIs
    ├── Get All Users (if available)
    ├── Delete Any Task (if admin-only)
    └── Admin Dashboard (if available)
---

#  Authorization Header

```http
Authorization: Bearer YOUR_JWT_TOKEN

## Note
I deployed backend part on render so hitting any first API will take 40-50 sec , then will take very less Time (free render plan)

## Greeting
## 🤝 Opportunity

I enjoyed building this project and would be grateful for the opportunity to contribute as a Backend Developer Intern. Thank you for reviewing my assignment.
