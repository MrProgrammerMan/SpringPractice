# README

## Overview
This project is a practice Spring Boot application that manages concerts and related entities:
- Organizor
- Venue
- Artist
- Concert

It uses Thymeleaf for rendering pages, PostgreSQL for persistence, and includes Flyway migrations.

## Prerequisites
1. Java 21
2. Maven  
3. Docker & docker-compose (for `postgres`)

## Getting Started
1. Clone this repository.  
2. Run the database container with:
   ```bash
   sudo docker compose up -d
   ```
3. Run the flyway migrations (sets up tables) with:
   ```bash
   mvn flyway:migrate
   ```
4. Run the project using Maven:
   ```bash
   mvn spring-boot:run
   ```

## Tasks

### 1. Create Repositories
1. In the src/main/java/no/oslomet/klatrestudy/repositories package, create interfaces that extend JpaRepository
2. Repeat this for `Venue`, `Artist`, and `Concert` entities.

### 2. Create Services
1. In the src/main/java/no/oslomet/klatrestudy/services package, create service classes that have a repository and expose methods lige getById() and other crud operations. Business logic goes here too.   
2. Repeat for `VenueService`, `ArtistService`, and `ConcertService`.

### 3. Create Controllers
In the src/main/java/no/oslomet/klatrestudy/controllers package, create controllers for each entity that handle different endpoints (routes).

### 4. Thymeleaf Templates
Add Thymeleaf templates with functionality to access the routes for the crud operations.

### 5. Testing
Run tests locally:
```bash
mvn test
```
GitHub Actions is configured in test.yaml to run these tests on each push.

## Conclusion
This structure sets up a basic CRUD system for an admin interface. You can expand on this by adding conditional logic, advanced queries, or additional entities.
