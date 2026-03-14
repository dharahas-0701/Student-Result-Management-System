# Student Result Management System

This project is a simple **Student Result Management System** built using **Java, JDBC, and MySQL**.  
It is a console-based application that allows administrators to manage student records and results while students can securely log in to view their own results.

The goal of this project is to demonstrate how a Java application can interact with a database using **JDBC** and manage structured data through a relational database system.

---

## Features

* Admin login system
* Student login with password
* Add new student records
* Enter marks for multiple subjects
* Automatically calculate total marks and percentage
* View complete student results
* Students can only view their own results
* Simple menu-driven console interface
* MySQL database integration using JDBC

---

## Technologies Used

* Java  
* JDBC (Java Database Connectivity)  
* MySQL  
* Maven  

---

## Main Components

The project contains the following main classes:

* **DBConnection.java** – Handles the connection between Java and the MySQL database.
* **AdminLogin.java** – Allows administrators to log in and manage student records.
* **StudentLogin.java** – Handles authentication for students using their ID and password.
* **AddStudent.java** – Adds student details such as ID, name, department, semester, and password.
* **AddResult.java** – Stores subject marks and calculates total and percentage.
* **ViewResult.java** – Retrieves and displays student results from the database.
* **Main.java** – Contains the menu-driven program that allows users to interact with the system.

---

## Database Setup

Before running the program, create the database and tables in MySQL.

### Create Database

```sql
CREATE DATABASE student_result;
```

### Use Database

```sql
USE student_result;
```

### Create Students Table

```sql
CREATE TABLE students(
    id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    semester INT,
    password VARCHAR(50)
);
```

### Create Results Table

```sql
CREATE TABLE results(
    student_id INT,
    subject1 INT,
    subject2 INT,
    subject3 INT,
    subject4 INT,
    subject5 INT,
    total INT,
    percentage DOUBLE,
    FOREIGN KEY(student_id) REFERENCES students(id)
);
```

### Create Admin Table

```sql
CREATE TABLE admins(
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50)
);
```

Insert a default admin account:

```sql
INSERT INTO admins VALUES ('admin','admin123');
```

---

## Configure Database Connection

Open **DBConnection.java** and update the database credentials:

```java
private static final String URL = "jdbc:mysql://127.0.0.1:3306/student_result";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

Replace `your_password` with your MySQL password.

---

## How to Run the Project

1. Clone the repository  
2. Open the project in IntelliJ IDEA or VS Code  
3. Create the database and tables in MySQL  
4. Update database credentials in `DBConnection.java`  
5. Run `Main.java`

---

## Example Program Flow

When the program runs, the menu appears:

```
===== Student Result Management System =====

1 Admin Login
2 Student Login
3 Exit
```

### Admin Menu

```
1 Add Student
2 Add Result
3 View Result
```

### Student Login Example

```
Enter Student ID: 101
Enter Password: student123
```

---

## Example Result Output

```
===== Student Result =====

Student ID: 101
Name: John
Department: CSE
Semester: 4

Subject1: 80
Subject2: 75
Subject3: 82
Subject4: 90
Subject5: 88

Total: 415
Percentage: 83.0
```

---

## Future Improvements

Some possible improvements for this project include:

* Updating student records
* Deleting student data
* Searching student results
* Adding grade calculation
* Password encryption for better security
* Creating a GUI using Java Swing or JavaFX
* Converting the system into a web application
