Core banking functionalities project which provides APIs to create customers, search customers by ID, create bank accounts linked to specific customers, and transfer money between different accounts.

**Technologies Used**

•	Java 17
•	Spring Framework
•	Spring Security
•	Spring Boot
•	Spring Data JPA
•	H2 Database
•	MapStruct
•	Swagger UI
•	JUnit 5

**Getting Started**

**Prerequisites**

•	Java 17 or higher
•	Maven

**Installation**

1.	Clone the repository: git clone [https://github.com/rasoolghafari/bankingapplication.git](https://github.com/rasoolghafari/bankingapplication.git)
2.	Navigate to the project directory: ```cd banking-application```
3.	Build the project using Maven: ```mvn clean install```

**Usage**

1.	Run the application using Maven: ```mvn spring-boot:run```
2.	Access the Swagger UI at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) to view and test the APIs.
3.	Use the default username/password for APIs: ```user/user```.

**Unit Tests**

Unit tests have been written for the controllers using JUnit 5 and Mockito. These tests ensure the functionality of the API endpoints and verify the expected behavior.
To run the unit tests, navigate to the project directory and run the following command:

```mvn test```

**Database**

The application uses an in-memory H2 database for storing customer and account information. The database is automatically created and initialized with test data when the application starts. The database connection properties can be configured in the application.properties file.

**MapStruct**

MapStruct is used to convert DTOs (Data Transfer Objects) to entities and vice versa. It simplifies the mapping process and reduces boilerplate code.

**Exception Handling**

Exception handling is implemented using Spring's @ControllerAdvice and @ExceptionHandler annotations. This allows for centralized exception handling and provides custom error responses for different types of exceptions.

**License**

This project is licensed under the MIT License - see the LICENSE file for details.

