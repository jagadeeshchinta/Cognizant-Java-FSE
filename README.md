# Cognizant Digital Nurture 4.0 – Week 1 Assignments

This repository contains the solutions for Week 1 assignments of the Cognizant Digital Nurture 4.0 program. The assignments demonstrate the implementation of Design Patterns and Data Structures & Algorithms concepts using Java.

---

## Repository Structure

```
Cognizant-DesignPatterns
│
├── SingletonPatternExample
├── FactoryMethodPatternExample
├── FinancialForecasting
├── EcommerceSearch
└── README.md
```

---

# Exercise 1: Singleton Pattern

### Objective
Implement the Singleton Design Pattern to ensure that only one instance of the Logger class exists throughout the application.

### Concepts Used
- Singleton Design Pattern
- Private Constructor
- Static Instance
- Static Factory Method

### Files
- Logger.java
- TestLogger.java

### Output

```
Logger Created
Log: Application Started
Log: User Logged In
Only one Logger instance exists.
```

---

# Exercise 2: Factory Method Pattern

### Objective
Implement the Factory Method Design Pattern to create different types of documents without exposing object creation logic.

### Concepts Used
- Factory Method Pattern
- Abstraction
- Interfaces
- Inheritance
- Polymorphism

### Files
- Document.java
- WordDocument.java
- PdfDocument.java
- ExcelDocument.java
- DocumentFactory.java
- WordFactory.java
- PdfFactory.java
- ExcelFactory.java
- FactoryTest.java

### Output

```
Opening Word Document
Opening PDF Document
Opening Excel Document
```

---

# Exercise 3: Financial Forecasting (Recursion)

### Objective
Develop a financial forecasting tool that predicts future investment values using recursion.

### Concepts Used
- Recursion
- Base Case
- Recursive Calls
- Time Complexity Analysis

### Files
- FinancialForecast.java

### Output

```
Future Value after 5 years = 16105.10
```

### Complexity

- Time Complexity: O(n)
- Space Complexity: O(n)

---

# Exercise 4: E-commerce Platform Search Function

### Objective
Implement Linear Search and Binary Search algorithms to search products efficiently.

### Concepts Used
- Linear Search
- Binary Search
- Arrays
- Big O Notation
- Algorithm Analysis

### Files
- Product.java
- LinearSearch.java
- BinarySearch.java
- SearchTest.java

### Output

```
Linear Search:
103 | Shoes | Fashion

Binary Search:
104 | Watch | Accessories
```

### Complexity Comparison

| Algorithm | Best | Average | Worst |
|-----------|------|---------|-------|
| Linear Search | O(1) | O(n) | O(n) |
| Binary Search | O(1) | O(log n) | O(log n) |

### Conclusion

Binary Search is more efficient for large datasets because it reduces the search space by half in each iteration. However, it requires the data to be sorted.

---

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Design Patterns
- Data Structures & Algorithms
- Visual Studio Code
- Git & GitHub

---

## Author

**Jagadeesh Chinta**

B.Tech – Computer Science and Engineering

Lovely Professional University

---


# Week 2 – PL/SQL Programming Exercises

## Overview
This project contains solutions for Week 3 PL/SQL exercises as part of the Cognizant Digital Nurture Program.

## Exercises Completed

### Exercise 1: Control Structures
- Applied a 1% interest discount for customers above 60 years.
- Updated VIP status for customers with a balance greater than 10,000.
- Generated reminder messages for loans due within the next 30 days.

### Exercise 2: Stored Procedures
- **ProcessMonthlyInterest** – Updates savings account balances by applying 1% monthly interest.
- **UpdateEmployeeBonus** – Updates employee salaries by adding a bonus percentage for a specified department.
- **TransferFunds** – Transfers funds between accounts after checking sufficient balance.

## Files

- `schema.sql` – Database table creation scripts.
- `sample_data.sql` – Sample data for testing.
- `ControlStructures.sql` – PL/SQL control structure solutions.
- `StoredProcedures.sql` – Stored procedure implementations.

## Technologies Used

- Oracle PL/SQL
- Oracle SQL
- SQL*Plus / Oracle Database 11g XE

## Author

**Jagadeesh Chinta**