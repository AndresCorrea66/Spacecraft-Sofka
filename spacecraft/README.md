# Spacecraft Application
This is a sample Java-based application that implements a class hierarchy for different types of spacecrafts and exposes the functionality through a REST API.

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Lombok
* H2
* Maven

## Prerequisites

* Java 8
* Maven 3.x

## How to Run

* Clone the repository to your local machine.
* Navigate to the root directory of the project.
* Run the following command to build the project:
`mvn clean install`
* After the build is successful, run the following command to start the application: `mvn spring-boot:run`
* The application will be running at http://localhost:8080.

You can use a REST client such as Postman to interact with the API.

## Endpoints

The application exposes the following endpoints:

1. GET `/spacecrafts`: Retrieves a list of all spacecrafts.
2. GET `/spacecrafts/search?keywords=space`: Retrieves a specific spacecraft by name.
3. GET `/spacecrafts/search-by-speed?minSpeed=150&maxSpeed=350`: Retrieves a list of spacecrafts by speed range.
4. POST `/spacecrafts`: Adds a new spacecraft.