# Simplified Exam Management System

This is a monolith MVC web application for managing exams, built with Spring Boot, JSF (PrimeFaces), and MySQL.

## How to Run

1.  **Create MySQL Database**

    Open a MySQL client and run the following command:

    ```sql
    CREATE DATABASE sge_db;
    ```

2.  **Configure Database**

    Open `src/main/resources/application.properties` and update the following properties with your MySQL username and password:

    ```properties
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```

3.  **Run the Application**

    Use Maven to run the application:

    ```bash
    mvn spring-boot:run
    ```

4.  **Access the Application**

    Open your web browser and go to `http://localhost:8080`.
