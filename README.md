# 🐦 Social Media Platform (Twitter Clone) – Spring Boot REST API

This project implements a lightweight Twitter-style backend using **Java**, **Spring Boot**, and an **H2 in-memory database**, developed as a major assignment for an Object-Oriented Programming course. It focuses on building a fully functional **RESTful API** that supports user authentication, post creation, commenting, and retrieval — following object-oriented principles and stateless API design.

---

## 🌐 Project Overview

The application simulates a minimal social media backend, enabling users to:
- Sign up and log in
- Create, read, update, and delete posts
- Comment on posts
- View a global user feed sorted by post creation time
- Retrieve and display user-specific data

All operations are accessible via well-defined REST endpoints and tested using **Postman**. The application uses **Spring Boot** for request handling and **H2** as an in-memory data store for quick development and testing.

---

## 📦 Features

- User authentication and account creation with validation
- CRUD operations for posts and comments
- Reverse-chronological user feed
- Structured JSON request/response schema
- Object-oriented controller-service-repository architecture
- Error handling with meaningful response messages
- Tested with a comprehensive Postman collection

---

## 🧪 Tech Stack

- **Java**  
- **Spring Boot** – REST API framework  
- **H2 Database** – in-memory relational DB  
- **Postman** – for API testing
---

## 📂 Endpoints Summary

| Resource       | Method | Endpoint        | Description                        |
|----------------|--------|-----------------|------------------------------------|
| User Login     | POST   | `/login`        | Log in with email and password     |
| User Signup    | POST   | `/signup`       | Register a new user                |
| User Details   | GET    | `/user?userID=` | Fetch user profile by ID           |
| All Users      | GET    | `/users`        | List all users and their posts     |
| User Feed      | GET    | `/`             | View all posts across users        |
| Post CRUD      | POST/GET/PATCH/DELETE | `/post` with params | Create, read, update, delete posts |
| Comment CRUD   | POST/GET/PATCH/DELETE | `/comment` with params | Same for comments                  |

> For full request/response structures, see the [Postman collection](https://bold-robot-635964.postman.co/workspace/My-Workspace~fdcf320c-d95e-4a0f-8014-7f96e0ac11bd/collection/24752303-7dc37d1a-2404-4a0a-8ecf-b33facb1a9b9?action=share&creator=24752303)

---

