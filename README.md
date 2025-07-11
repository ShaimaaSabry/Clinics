# Doctor's Clinic

Platform for managing a doctor's clinic. The doctor adds available slots for appointments, and patients book these slots. Confirmation notifications are sent to the patient and the doctor once an appointment is scheduled. The doctor can view booked appointments, and mark them as complete or cancelled.

Swagger: http://localhost:8080/swagger-ui/index.html

## Architecture

This platform is built using modular monolith architecture. Thus, this project is divided into the following modules:
* slots: allows the doctor to add available slots for appointments.
* booking: allows patients to book available slots.
* notifications: allows the system to send notifications to the patient and the doctor once an appointment is scheduled.
* appointments: allows the doctor to view booked appointments and mark them as complete or cancelled.

## Technologies
* Java 21
* Gradle
* Spring Boot 3.4
* PostgreSQL
* Docker Compose

## Run Locally

1. Start docker compose:
    ```bash
    docker-compose up
    ```
   
2. Run the Spring Boot application:
    ```bash
    ./gradlew bootRun
    ```

## Tests & Linting

* Linting:
    ```
   ./gradlew ktlintFormat
    ```

* Unit tests:
    ```
   ./gradlew test
    ```

* Code coverage:
    ```
   ./gradlew jacocoTestReport
    ```

* Integration tests:
    ```
   ./gradlew integrationTest
    ```

## Authors & Copyright
Shaimaa Sabry