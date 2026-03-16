package com.qa.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * General API Validation Suite
 * Focuses on fundamental HTTP assertions and data integrity checks.
 */
public class ApiValidationTest {

    @BeforeClass
    public void setup() {
        // Base URL for demonstration purposes
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test(description = "Check if the GET endpoint returns a 200 status and non-empty body")
    public void validateResourceList() {
        given()
            .header("Content-Type", "application/json")
        .when()
            .get("/posts")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("size()", greaterThan(0))
            .log().ifValidationFails();
    }

    @Test(description = "Verify that a single resource contains the expected fields")
    public void validateResourceDetails() {
        int targetId = 1;
        
        given()
            .pathParam("id", targetId)
        .when()
            .get("/posts/{id}")
        .then()
            .statusCode(200)
            .body("id", equalTo(targetId))
            .body("title", not(emptyOrNullString()))
            .body("body", notNullValue());
    }

   @Test(description = "Verify creating a new resource via POST")
    public void validateCreateResource() {
        String payload = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

        given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/posts")
        .then()
            .statusCode(201) // 201 means 'Created'
            .body("title", equalTo("foo"))
            .body("id", notNullValue());
    } 
}