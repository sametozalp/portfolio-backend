# Portfolio Backend

A Spring Boot backend API for a personal portfolio website with comprehensive content management capabilities.

## Overview

This backend provides a complete REST API for managing portfolio content including personal information, projects, experience, education, skills, and contact functionality. It's designed to work with a React frontend (available at [portfolio-react](https://github.com/sametozalp/portfolio-react)).

## Features

- **Content Management**: Full CRUD operations for all portfolio entities
- **Authentication**: Secure authentication system
- **Contact Form**: Email notification system for contact submissions
- **Database Integration**: PostgreSQL with JPA/Hibernate
- **API Documentation**: OpenAPI/Swagger documentation
- **Email Service**: Gmail SMTP integration for notifications
- **Validation**: Comprehensive input validation
- **DTO Pattern**: Clean separation between API and business layers

## Tech Stack

- **Framework**: Spring Boot 3.5.9
- **Language**: Java 21
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA with Hibernate
- **Documentation**: SpringDoc OpenAPI 2.8.9
- **Validation**: Spring Boot Validation
- **Email**: Spring Boot Mail
- **Utilities**: Lombok, MapStruct
- **Build Tool**: Maven

## Project Structure

```
src/main/java/com/ozalp/portfolio/
├── PortfolioApplication.java          # Main application entry point
├── controllers/                       # REST API controllers
│   ├── AboutController.java
│   ├── AuthController.java
│   ├── ContactController.java
│   ├── CopyrightController.java
│   ├── EducationController.java
│   ├── EntranceController.java
│   ├── ExperienceController.java
│   ├── MainController.java          # Main portfolio data endpoint
│   ├── ProjectCategoryController.java
│   ├── ProjectController.java
│   ├── SkillController.java
│   └── SocialController.java
├── business/                         # Business logic layer
│   ├── dtos/                         # Data Transfer Objects
│   │   ├── requests/                 # Request DTOs
│   │   │   ├── create/              # Create request DTOs
│   │   │   └── update/              # Update request DTOs
│   │   └── responses/                # Response DTOs
│   └── services/                     # Service interfaces and implementations
├── core/                             # Core configuration
│   ├── config/                       # Configuration classes
│   ├── exceptions/                   # Custom exceptions
│   └── utilities/                    # Utility classes
├── dataAccess/                       # Data access layer
│   ├── entities/                     # JPA entities
│   └── repositories/                 # Spring Data repositories
└── mappers/                          # MapStruct mappers
```

## Database Schema

The application manages the following entities:

- **About**: Personal information and bio
- **Contact**: Contact details and form submissions
- **Copyright**: Footer copyright information
- **Education**: Educational background
- **Entrance**: Hero section content
- **Experience**: Work experience
- **Project**: Portfolio projects with categories
- **Skill**: Technical skills
- **Social**: Social media links

## API Endpoints

### Main Portfolio Data
- `GET /api/main` - Retrieves all portfolio data in a single response

### Individual Entity Management
- `GET /api/{entity}` - Get all records
- `GET /api/{entity}/{id}` - Get specific record
- `POST /api/{entity}/add` - Create new record
- `PUT /api/{entity}/update/{id}` - Update existing record
- `DELETE /api/{entity}/delete/{id}` - Delete record

### Authentication
- `POST /api/auth/login` - User authentication
- `POST /api/auth/register` - User registration

### Contact Form
- `POST /api/contact/add` - Submit contact form
- `POST /api/contact/mail` - Send email notification

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- PostgreSQL 12 or higher
- Gmail account (for email functionality)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/sametozalp/portfolio-backend.git
   cd portfolio-backend
   ```

2. **Set up the database**
   ```sql
   CREATE DATABASE portfolio;
   ```

3. **Configure application properties**
   
   Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/portfolio
   spring.datasource.username=your_postgres_username
   spring.datasource.password=your_postgres_password
   
   spring.mail.username=your_gmail_address
   spring.mail.password=your_gmail_app_password
   ```

4. **Build and run the application**
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

The application will start on `http://localhost:8080`

### API Documentation

Once the application is running, you can access the Swagger UI at:
- `http://localhost:8080/swagger-ui.html`

## Configuration

### Database Configuration

The application uses PostgreSQL with the following default configuration:
- Host: localhost
- Port: 5432
- Database: portfolio
- Hibernate DDL: update (automatically creates/updates schema)

### Email Configuration

The email service uses Gmail SMTP. To enable email notifications:
1. Enable 2-factor authentication on your Gmail account
2. Generate an App Password
3. Update the mail configuration in `application.properties`

## Environment Variables

You can also configure the application using environment variables:

```bash
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/portfolio
export SPRING_DATASOURCE_USERNAME=your_username
export SPRING_DATASOURCE_PASSWORD=your_password
export SPRING_MAIL_USERNAME=your_gmail@gmail.com
export SPRING_MAIL_PASSWORD=your_app_password
```

## Development

### Running Tests

```bash
./mvnw test
```

### Building for Production

```bash
./mvnw clean package -Pprod
```

### Code Quality

The project uses:
- Lombok for reducing boilerplate code
- MapStruct for object mapping
- Spring Boot Validation for input validation

## Frontend Integration

This backend is designed to work seamlessly with the React frontend:
- **Frontend Repository**: [portfolio-react](https://github.com/sametozalp/portfolio-react)
- **API Base URL**: `http://localhost:8080`
- **Main Endpoint**: `/api/main` (provides all portfolio data in one call)

## Contact

Samet Özalp - [GitHub](https://github.com/sametozalp)

## Acknowledgments

- Spring Boot team for the excellent framework
- PostgreSQL community for the robust database
- All contributors who have helped with this project
