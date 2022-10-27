# Exepense-Tracker-Application

## Description


-  REST API for an Expense Tracker Application. This API performs all the fundamental CRUD operations of any Expense tracker platform with user validation at every step.
- This is an individual project.

 
## Techstack

- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL

## Modules

- User Module
- Expense Module
- Authentication Module

## Features

* User authentication & validation using sping security.
* User Features:
    * Registering themselves with application, and logging in to application
    * Viewing list of expenses by user.
    * Only logged in users can update his/her expense, profile updation and other features.
    
    
## Installation & Run

- Before running the API server, you should update the database config inside the [application.properties](https://github.com/yendasivakumar/Exepense-Tracker-Application) file.
- Update the port number, username and password as per your local database config.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/busdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

