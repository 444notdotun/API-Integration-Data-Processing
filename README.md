# API Integration & Data Processing Assessment

## 📌 Overview

This project is a Spring Boot backend application that exposes a REST API endpoint for gender classification based on a given name.

It integrates with the external **Genderize API**, processes the response, and returns a structured, enriched result based on defined business rules.

---

## 🚀 Live API

**Base URL:**

```
https://hng-stage0-183135031185.us-central1.run.app
```

**Endpoint:**

```
GET /api/classify?name=<name>
```

**Example:**

```
https://your-api-url.com/api/classify?name=alex
```

---

## ⚙️ Features

* External API integration (Genderize)
* Data transformation and enrichment
* Confidence scoring logic
* Input validation
* Structured error handling
* ISO 8601 UTC timestamp generation
* CORS enabled for public access

---

## 🧠 Processing Logic

The API processes the external response as follows:

* Extracts:

  * `gender`
  * `probability`
  * `count` → renamed to `sample_size`

* Computes:

  * `is_confident = true` if:

    * `probability >= 0.7`
    * AND `sample_size >= 100`

* Adds:

  * `processed_at` (UTC, ISO 8601 format)

---

## 📥 Request

### Query Parameters

| Parameter | Type   | Required | Description      |
| --------- | ------ | -------- | ---------------- |
| name      | String | Yes      | Name to classify |

---

## 📤 Response

### ✅ Success Response

```json
{
  "status": "success",
  "data": {
    "name": "alex",
    "gender": "male",
    "probability": 0.99,
    "sample_size": 1234,
    "is_confident": true,
    "processed_at": "2026-04-01T12:00:00Z"
  }
}
```

---

### ❌ Error Responses

#### 400 Bad Request

```json
{
  "status": "error",
  "message": "Missing or empty name parameter"
}
```

#### 422 Unprocessable Entity

```json
{
  "status": "error",
  "message": "Name must be a string"
}
```

#### No Prediction Available

```json
{
  "status": "error",
  "message": "No prediction available for the provided name"
}
```

#### 500 Internal Server Error

```json
{
  "status": "error",
  "message": "Internal server error"
}
```

---

## ⚠️ Edge Case Handling

If the external API returns:

* `gender = null`
* OR `count = 0`

The API responds with:

```
No prediction available for the provided name
```

---

## 🛠️ Tech Stack

* Java 17+
* Spring Boot
* REST APIs
* Maven
* RestTemplate (HTTP client)

---



## ▶️ Running Locally

### 1. Clone the repository

```
git clone https://github.com/444notdotun/API-Integration-Data-Processing.git
```

### 2. Navigate into the project

```
cd your-repo
```

### 3. Run the application

```
./mvnw spring-boot:run
```

### 4. Test the API

```
http://localhost:8080/api/classify?name=alex
```

---

## 🌍 Deployment

This API is deployed and publicly accessible for testing.

Ensure:

* The server is running during evaluation
* Endpoint responds within acceptable time

---

## 📊 Evaluation Criteria Covered

* ✅ Endpoint availability
* ✅ Query parameter handling
* ✅ External API integration
* ✅ Data extraction and transformation
* ✅ Confidence logic implementation
* ✅ Error handling
* ✅ Edge case handling
* ✅ Response structure compliance

---



---

## 📄 License

This project is for assessment purposes.
