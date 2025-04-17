# Employee Management System

A simple Java and Spring Boot based console application for managing employee records. This project demonstrates core Java programming principles, especially object-oriented design and CRUD (create, read, update, delete) operations.

## 🚀 Features

- Add a new employee  
- View all employees  
- Search employees by ID, name, last name, gender, phone number, or email  
- Update employee details  
- Delete an employee   

## 🛠️ Tech Stack

- Java 17+  
- Spring Boot  
- Spring Data JPA  
- H2 / MySQL (configurable)  
- Maven  

## ⚙️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/umuttbariss/Employee_Management_System
   cd Employee_Management_System
   ```

2. Build and run the project:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Open your browser or use a REST client like Postman to interact with:
   ```
   http://localhost:8080/api/employees
   ```

## 📦 Example API Usage

### ➕ Add Employee

**Request:**
```http
http://localhost:8080/api/employees/add
Content-Type: application/json
```

**Body:**
```json
{
     "firstName": "Umut",
     "lastName": "Dal",
     "gender": "Male",
     "salary": "10000",
     "email": "umut@hotmail.com",
     "phoneNumber": "1234567890"
   }
```

**Response:** `201 Created`

---

### 📥 Get All Employees

**Request:**
```http
http://localhost:8080/api/employees/all
```

**Response:** `200 OK`

---

### 🔍 Get Employee by ID

**Request:**
```http
http://localhost:8080/api/employees/id/{id}
```

**Response:** `200 OK`

---

### 🔎 Get Employees by Name

**Request:**
```http
http://localhost:8080/api/employees/name/{name}
```

**Example:**
```http
http://localhost:8080/api/employees/name/Umut
```

**Response:** `200 OK`  
Returns a list of employees with the given first name.

---

### 🔎 Get Employees by Last Name

**Request:**
```http
http://localhost:8080/api/employees/lastname/{lastName}
```

**Example:**
```http
http://localhost:8080/api/employees/lastname/Dal
```

**Response:** `200 OK`  
Returns a list of employees with the given last name.

---

### 🔎 Get Employees by Gender

**Request:**
```http
http://localhost:8080/api/employees/gender/{gender}
```

**Example:**
```http
http://localhost:8080/api/employees/gender/Male
```

**Response:** `200 OK`  
Returns a list of employees with the specified gender.

---

### 🔎 Get Employees by Phone Number

**Request:**
```http
http://localhost:8080/api/employees/phonenumber/{phoneNumber}
```

**Example:**
```http
http://localhost:8080/api/employees/phonenumber/1234567890
```

**Response:** `200 OK`  
Returns a list of employees with the specified phone number.

---

### 🔎 Get Employee by Email

**Request:**
```http
http://localhost:8080/api/employees/email/{email}
```

**Example:**
```http
http://localhost:8080/api/employees/email/umut@hotmail.com
```

**Response:** `200 OK`  
Returns the employee object with the given email address.

---

### ✏️ Update Employee

**Request:**
```http
http://localhost:8080/api/employees/update/{id}
Content-Type: application/json
```

**Body:**
```json
{
     "firstName": "Baris",
     "lastName": "Dal",
     "gender": "Male",
     "salary": "20000",
     "email": "baris@hotmail.com",
     "phoneNumber": "1111111111"
   }
```

**Response:** `200 OK`

---

### ❌ Delete Employee

**Request:**
```http
http://localhost:8080/api/employees/delete/{id}
```

**Response:**
```text
200 OK
"Successfully deleted."
```
