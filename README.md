# student-registration-form


This project is a Student Management System built with Spring Boot, JPA, and MySQL. It allows for registration, updating, deletion, and viewing of students, along with displaying student courses and balance fees.

# Features
Home Page: A simple landing page.
Student Registration: Allows users to register new students.
Student Management: View all students, update their information, and delete them.
Courses: List students based on their courses.
Balance Fees: View students with balance fees.
Courses with Balance Fees: View students grouped by courses with balance fees.

# Technologies Used
Spring Boot: Backend framework.
JPA: For database interaction.
MySQL: Relational database for storing student information.
Thymeleaf: Templating engine for the frontend.
Maven: Dependency management and build tool.

# Project Setup
Prerequisites
Java 11 or later
MySQL installed locally or on a server

# Setup Instructions
Clone the repository:
git clone https://github.com/your-username/student-management.git
Install dependencies using Maven:
mvn clean install

# Set up MySQL database:

Create a database named student in MySQL.
Modify the application.properties file with your MySQL credentials:
properties
spring.datasource.url=jdbc:mysql://localhost:3306/student
spring.datasource.username=your-username
spring.datasource.password=your-password

# Run the application:
mvn spring-boot:run
Access the application at: http://localhost:8888

# Endpoints
Home Page: GET /student/
Registration Page: GET /student/register
Save Student: POST /student/save
Get All Students: GET /student/getAllStudents
Edit Student: GET /student/edit?id={id}
Update Student: POST /student/update
Delete Student: GET /student/delete?id={id}
View Courses: GET /student/courses
View Balance Fees: GET /student/balanceFees
Courses with Balance Fees: GET /student/coursesWithBalanceFees

# File Structure
bash
Copy
Edit
src/
│
├── main/
│   ├── java/
│   │   └── com/
│   │       └── pinnacle/
│   │           └── student/
│   │               ├── controller/        # Controller classes
│   │               ├── model/              # Entity classes
│   │               ├── repository/         # Repository interfaces
│   │               ├── service/            # Service interfaces and implementations
│   │               └── service/impl/        # Service Implementations
│   ├── resources/
│   │   └── templates/                     # Thymeleaf templates (HTML files)
│   │   └── application.properties         # Configuration file
│
└── pom.xml                               # Maven configuration file

# Configuration
The project uses application.properties for configuration. Some key configurations:

spring.application.name=Students
server.port=8888
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/student
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update

# How to Use
Register a Student
Navigate to /student/register to fill in the student details and submit the form.
View All Students
After registering students, you can view them by navigating to /student/getAllStudents.
Edit a Student
To edit a student's details, navigate to /student/edit?id={id}, update the details, and save.
Delete a Student
To delete a student, click the delete button in the student list or navigate to /student/delete?id={id}.
View Students by Course
To view students grouped by course, go to /student/courses.
View Students with Balance Fees
To view students with balance fees, go to /student/balanceFees.
View Courses with Balance Fees
To see courses that have students with balance fees, navigate to /student/coursesWithBalanceFees.

# Contributing
Fork the repository.
Create your feature branch (git checkout -b feature/your-feature).
Commit your changes (git commit -m 'Add new feature').
Push to the branch (git push origin feature/your-feature).
Create a new Pull Request.

# License
This project is licensed under the MIT License - see the LICENSE file for details.