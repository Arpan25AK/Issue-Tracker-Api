# 🚀 Issue Tracker API

A production-grade, containerized backend service for tracking software issues and feature requests. This project was built to demonstrate proficiency in **No-ORM (JDBC)** database management, microservices architecture, and DevOps integration.



## 🛠️ Tech Stack
* [cite_start]**Language:** Java 21 [cite: 11]
* [cite_start]**Framework:** Spring Boot 3.x [cite: 18]
* [cite_start]**Data Access:** Spring JDBC (`JdbcTemplate`) — No ORM approach [cite: 57]
* [cite_start]**Database:** MySQL 8.0 [cite: 20]
* [cite_start]**DevOps:** Docker & Docker Compose [cite: 21]
* [cite_start]**Build Tool:** Maven [cite: 51]
* [cite_start]**Testing:** JUnit 5 & Mockito [cite: 19]

## ✨ Key Features
* [cite_start]**Manual Persistence:** Full CRUD operations implemented using raw SQL and `RowMapper` logic for high performance and transparency[cite: 57].
* **Layered Architecture:** Strict separation of concerns across Controller, Service, DTO, and Repository layers.
* **Automated IDs:** Internal logic to handle UUID generation and timestamping for new records.
* **Global Exception Handling:** Standardized JSON error responses for `404 Not Found` and `500 Internal Server Error` scenarios.
* **Containerized Environment:** Single-command setup for both the API and the database using Docker Compose.

## 🚀 Getting Started

### Prerequisites
* Docker & Docker Compose installed.
* Postman (or `curl`) for testing endpoints.

### Installation & Run
1.  Clone the repository:
    ```bash
    git clone https://github.com/Arpan25AK/Issue-Tracker-Api.git
    cd Issue-Tracker-Api
    ```
2.  Spin up the environment:
    ```bash
    docker-compose up --build
    ```
    The API will be available at `http://localhost:8080`.

## 📡 API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **POST** | `/api/v1/issues` | Create a new issue |
| **GET** | `/api/v1/issues` | Retrieve all issues |
| **GET** | `/api/v1/issues/{id}` | Retrieve issue by ID |
| **PUT** | `/api/v1/issues/{id}` | Update existing issue |
| **DELETE** | `/api/v1/issues/{id}` | Remove an issue |

### Sample POST Request Body
```json
{
  "title": "Bug in Login Page",
  "description": "User cannot login with valid credentials.",
  "priority": "CRITICAL"
}
```

## 📂 Project Structure
```text
src/main/java/com/api/Issue_Tracker_Api/
├── controller/    # REST Endpoints
├── service/       # Business Logic & DTO Mapping
├── repository/    # JdbcTemplate & SQL Queries
├── entity/        # Database Models & Enums
├── dto/           # Request/Response Data Objects
└── exception/     # Global Error Handling
```

---

### How to add this:
1.  Create a file named `README.md` in your root folder (next to `pom.xml`).
2.  Paste the content above.
3.  Run the final Git commands:
    ```bash
    git add README.md
    git commit -m "docs: add comprehensive readme"
    git push origin main
    ```
