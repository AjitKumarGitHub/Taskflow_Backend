# 🚀 TaskFlow – Scalable Backend System with Authentication & RBAC

A production-structured full-stack backend system built using **Spring Boot, MongoDB, JWT Authentication**, and a modern frontend built with **Next.js + Tailwind CSS**.

This project demonstrates strong backend engineering principles including **secure authentication, role-based access control, modular architecture, and scalable API design**.

---

## 🌐 Live Demo

🔗 Frontend Application:  
[TaskFlow Frontend Live Demo](https://taskflow-frontend-five-sage.vercel.app/?utm_source=chatgpt.com)

---

## 🧠 Key Highlights

- 🔐 Secure JWT Authentication
- 👮 Role-Based Access Control (USER / ADMIN)
- 📦 Modular and Scalable Spring Boot Architecture
- 🗄️ MongoDB Atlas Integration
- ⚙️ RESTful API Design (Best Practices)
- 📄 Swagger API Documentation
- 🎯 Full CRUD Operations
- 💻 Responsive Frontend (Next.js + Tailwind)
- ☁️ Production-ready Deployment (Vercel + Atlas)

---

## 🏗️ System Architecture
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

## 🛠️ Tech Stack

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

## 📁 Project Structure

### Backend
workflow-backend/
├── controller
├── service
├── repository
├── security (JWT Filter, Config)
├── pojo
├── entity
├── exception
├── config
└── WorkflowApplication.java

---


---

## 🔐 Authentication Flow

1. User registers → password hashed using BCrypt  
2. Login generates JWT token  
3. Token stored in frontend (localStorage)  
4. Token sent in Authorization header  
5. Backend validates token via filter  
6. Role-based access enforced (USER / ADMIN)

---

## 📡 API Endpoints

### 🔑 Auth APIs

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

# 📡 API Endpoints

## 🔐 Authentication APIs

| Method | Endpoint | Description | Access |
|--------|-----------|-------------|---------|
| POST | `/api/v1/auth/register` | Register new user/admin | Public |
| POST | `/api/v1/auth/login` | Login user/admin | Public |

---

## 📋 Task APIs

| Method | Endpoint | Description | Access |
|--------|-----------|-------------|---------|
| POST | `/api/v1/tasks` | Create new task | USER / ADMIN |
| GET | `/api/v1/tasks` | Get all tasks | USER / ADMIN |
| GET | `/api/v1/tasks/{id}` | Get task by ID | USER / ADMIN |
| PUT | `/api/v1/tasks/{id}` | Update task | USER / ADMIN |
| DELETE | `/api/v1/tasks/{id}` | Delete task | ADMIN |

---

# 🔑 Authorization Header

```http
Authorization: Bearer YOUR_JWT_TOKEN
