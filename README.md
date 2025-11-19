Task Management là ứng dụng quản lý công việc với đầy đủ tính năng đăng nhập, phân quyền và quản lý task.
Hệ thống gồm:

Frontend: Angular 17+

Backend: Golang (Go kit microservice)

Database: PostgreSQL

Backend được viết theo kiến trúc clean + Go kit, dễ mở rộng, dễ bảo trì, hiệu năng cao.

✅ Tính năng chính
🔐 Authentication & Authorization

Đăng nhập / Đăng ký người dùng

JWT Authentication

Phân quyền (Admin / User)

Middleware xác thực JWT

Angular Route Guards

📋 Quản lý Task

Tạo task

Cập nhật task

Xóa task

Giao task cho user

Tìm kiếm / lọc task

UI responsive, tốc độ nhanh

🖥️ Frontend – Angular
Công nghệ sử dụng

Angular 17+

TypeScript

SCSS

Angular Router

Reactive Forms

RxJS Services

Tối ưu

Lazy loading modules

Pre-rendering tăng tốc load

State management đơn giản bằng RxJS

Build production tối ưu

⚙️ Backend – Golang (Go kit)
Công nghệ sử dụng

Go 1.22+

Go kit (service, endpoint, transport)

Gorilla Mux

SQLX

PostgreSQL

JWT Authentication

BCrypt password hashing

Kiến trúc Go kit
/cmd/server/main.go   → Khởi động HTTP server
/service              → Business logic
/endpoints            → Endpoint Go kit
/transport/http       → Handler HTTP + middleware
/repository           → PostgreSQL layer
/model                → Struct dữ liệu
/jwt                  → Token utilities

Điểm mạnh Backend

Phân lớp rõ ràng theo Go kit

Middleware: JWT verify, Logging, Recovery

Repository tách biệt, dễ đổi DB

Bcrypt hashing bảo mật

Có thể scale thành microservice

🗄️ Database – PostgreSQL

Các bảng chính:

users (username, email, password, role)

tasks (title, description, status, assignee_id, timestamps)

Hỗ trợ migration qua:

goose

hoặc chạy file SQL thủ công

🚀 Triển khai
Frontend (Angular)

Deploy trên Vercel

Config API trong environment.ts

Backend (Go kit)

Deploy được trên:

Linux server

Docker

VPS

Render / Railway / Fly.io
