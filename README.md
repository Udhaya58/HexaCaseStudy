## 🎥 Project Presentation Video  using ppt
https://drive.google.com/file/d/1JyxkvHZ3_FSvwWwrGyft2mjIQPIU23xZ/view?usp=sharing

## 🎥 Project Demo Presentation video 
https://drive.google.com/file/d/1vq7Bfpxpc01bxvsCLKa4FyW8-O-taj8v/view?usp=sharing
## PPT of the project
https://docs.google.com/presentation/d/1o-D580Sy5MORekWApRFnJaL3GpMHIvrp/edit?usp=sharing&ouid=101941230146649101203&rtpof=true&sd=true


# 🍽️ Food Ordering System (Spring Boot)

A complete multi-role (User, Restaurant, Admin) food ordering system built with Spring Boot, JPA, and Spring Security. This RESTful application allows users to browse menus, place orders, restaurants to manage menus and orders, and admins to oversee the system.

---

## 🛠️ Tech Stack

- **Spring Boot** (REST API)
- **Spring Security** (Role-based authentication)
- **Spring Data JPA** (Hibernate)
- **MySQL** (Database)
- **Springdoc OpenAPI (Swagger)** – API documentation

---

## 👥 User Roles

### 👤 **User**
- Register, Login
- Browse menus with filters & search
- Add items to cart
- Checkout with address & payment info
- View order history

### 🍽️ **Restaurant**
- Login
- Create / Update / Delete menu and categories
- Mark items as out of stock
- Manage incoming orders and update delivery status
- View menu order history

### 👨‍💼 **Admin**
- Login
- Add / Remove restaurants
- Add / Modify / Remove menu items and categories
- Manage all users

---

## 🚀 Features

- ✅ Role-based login (User, Restaurant, Admin)
- ✅ Menu categories and filtering (Veg/Nonveg, price)
- ✅ Cart management (add, remove, update)
- ✅ Secure order checkout
- ✅ Restaurant dashboard for managing menus & orders
- ✅ Admin dashboard for global system control
- ✅ RESTful API design
- ✅ Swagger API documentation

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.example.foodorderingsystem
│   │       ├── config/              # Security Config
│   │       ├── controller/          # All controllers by role
│   │       ├── model/              # User, Menu, Order, Cart, etc.
│   │       ├── repository/          # JPA Repositories
│   │       ├── service/             # Business logic
│   │       └── dto/                 # Request/Response DTOs
│   └── resources/
│       └── application.properties
└── test/
    └── unit tests
```

---

## 🔐 Authentication

- Spring Security with role-based access control
- BCrypt password encoding
- Form-based login or Basic Auth (customizable)
- User roles: `USER`, `RESTAURANT`, `ADMIN`

---

## 🔧 API  Some of the Endpoints

Use Swagger UI to explore all endpoints:
```
http://localhost:8080/swagger-ui/index.html
```

Key endpoints:
| Endpoint | Method | Role | Description |
|----------|--------|------|-------------|
| `/auth/register` | POST | All | Register new user or restaurant |
| `/auth/login` | POST | All | Login |
| `/menus` | GET | User | Browse menus |
| `/cart` | GET/POST/PUT/DELETE | User | Manage cart |
| `/orders/checkout` | POST | User | Place order |
| `/restaurant/menus` | CRUD | Restaurant | Manage menu items |
| `/admin/users` | GET/DELETE | Admin | Manage users |

---

## ✅ Getting Started

### 1. Clone the repo
```bash
git clone https://github.com/your-username/food-ordering-system.git
cd food-ordering-system
```

### 2. Run the project
```bash
./mvnw spring-boot:run
```

### 3. Access Swagger UI
```bash
http://localhost:8080/swagger-ui/index.html
```

---






## 🙌 Contributions

Contributions, issues, and feature requests are welcome!  
Please open an issue or submit a pull request.

---

## 📬 Contact

Made by G.Udhayamoorthy 
📧 udhayamoorthy2058@gmail.com

