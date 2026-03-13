# Student Result Management System

This project is a simple **Student Result Management System** built using **Java, JDBC, and MySQL**.
It is a console-based application that allows users to store student information and manage their academic results.

The goal of this project is to demonstrate how a Java application can interact with a database using **JDBC**.

---

## Features

* Add new student records
* Enter marks for multiple subjects
* Automatically calculate total marks and percentage
* View complete student results
* Simple menu-driven console interface

---

## Technologies Used

* Java
* JDBC (Java Database Connectivity)
* MySQL
* Maven

---

## Main Components

The project contains a few main classes:

* **DBConnection.java** – Handles the connection between Java and the MySQL database.
* **AddStudent.java** – Adds student details such as ID, name, department, and semester.
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
    semester INT
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
2. Open the project in IntelliJ IDEA
3. Create the database and tables in MySQL
4. Update database credentials in `DBConnection.java`
5. Run `Main.java`

---

## Example Program Flow

When the program runs, the menu appears:

```
===== Student Result Management System =====

1. Add Student
2. Add Result
3. View Result
4. Exit
```

Example result output:

```
Student ID: 101
Name: John

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
* Creating a GUI using Java Swing
* Converting it into a web application
