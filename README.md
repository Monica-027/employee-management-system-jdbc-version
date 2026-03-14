# Employee Management System (JDBC)

A simple Java application that performs CRUD operations on an employee database using JDBC.

# Technologies Used:
- Java
- JDBC
- PostgreSQL
- Maven

# Features
- Add Employee
- View All Employees
- Update Employee
- Delete Employee
- Delete All Employee

# Database Setup
CREATE DATABASE ems;

CREATE TABLE employee (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100),
  salary DOUBLE PRECISION
);
# Database Configuration

Update credentials in DBConnection.java

public static final String URL = "jdbc:postgresql://localhost:5432/ems";

public static final String USERNAME = "db_name";

public static final String PASSWORD = "db_password";

# Project Structure
model       → Employee class

repository  → Database operations

service     → Business logic

util        → Database connection

Main        → Application entry point

# Key Concepts Used
- JDBC Connection
- PreparedStatement
- ResultSet
- Try-with-resources

# Author
Monica Prajapati
