# PhotoBacked Application

PhotoBacked is a Java Spring Boot application designed to manage and store photos. The application uses an in-memory H2 database with JDBC for database connectivity and performs basic operations such as uploading and retrieving photos. This is a simple project demonstrating how to integrate Spring Boot, H2 Database, and JDBC for file management.

## Features

- Upload and store photos in an H2 database.
- Retrieve stored photos via a REST API.
- Store metadata such as the file name and content type.
- Use JDBC for direct interaction with the database.
- In-memory H2 database for easy setup and testing.

## Technologies Used

- **Java** (Version 11 or higher)
- **Spring Boot** (Version 2.7.x or higher)
  - Spring Data JDBC
  - Spring Web (for REST APIs)
- **H2 Database** (In-memory database for development/testing)
- **Maven** (For project build and dependency management)

