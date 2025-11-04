# Java API Application
This application is a **Java Spring Boot-based** REST API.
The endpoint `/api/data` returns JSON data retrieved from **MySQL database** using JdbcTemplate.
Response returned in JSON format according to the reference file `viewData.json`.
Uses a separate architecture between **Model, Repository, and Controller (MVC)**.
# Application Specification
- **Language :** Java
- **Framework :** Spring Boot
- **Protocol :** HTTP
- **Method :** GET
- **Format Data :** JSON
- **Database :** MySQL
- **Dependency Management :** Maven
# Details
- **Application.java :** Spring Boot entry point
- **DataController.java :** Controller that handle API endpoint
- **DataRepository.java :** SQL data retrieval logic from the database (JdbcTemplate)
- **Transaction.java :** Transaction data model
- **Status.java :** Status model
- **ViewDataResponse.java :** Wrapper JSON response (data + status)

# How to use
- Install JDK 21
- Install XAMPP
- Run MySQL, create database using `CREATE DATABASE jawaban_java;`
- import the data from `jawaban.sql` file
- From Eclipse or terminal, `mvn spring-boot:run`
# API Testing
### Endpoint
`GET http://localhost:8080/api/data`
### Using curl
`curl http://localhost:8080/api/data`
or use python json module for *pretty* structure
`curl http://localhost:8080/api/data | python -m json.tool`
