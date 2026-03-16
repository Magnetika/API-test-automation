# API Automation Framework

### Project Overview
This repository contains a lightweight, scalable API automation framework built with **Java** and **REST-Assured**. The project demonstrates automated testing of RESTful endpoints, focusing on status code validation, data integrity, and error handling.

### Tech Stack
- **Language:** Java 11
- **Testing Library:** REST-Assured
- **Test Runner:** TestNG
- **Build Tool:** Maven

### Project Structure
- `src/test/java/com/qa/tests`: Contains the test suites.
- `pom.xml`: Manages project dependencies.

### Key QA Scenarios Covered
1. **Positive Testing (GET):** Validating successful resource retrieval.
2. **Functional Testing (POST):** Ensuring new resources are created correctly.
3. **Negative Testing (404):** Verifying correct error codes for non-existent resources.
4. **Data Integrity:** Checking JSON schema consistency.

### How to Run Tests
1. Ensure you have **Maven** and **JDK 11+** installed.
2. Clone the repository.
3. Navigate to the project folder and run:
   ```bash
   mvn clean test

Execution Reports
Test results are automatically generated. You can find the HTML report at:
target/surefire-reports/index.html

