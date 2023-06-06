package ru.testproject.steps.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostmanApiSteps {

    private static final String baseUri = "https://postman-echo.com";
    private static final RequestSpecification reqSpec = new RequestSpecBuilder()
            .setBaseUri(baseUri)
            .setContentType(ContentType.JSON)
            .addFilters(List.of(
                    new RequestLoggingFilter(),
                    new ResponseLoggingFilter(),
                    new AllureRestAssured())
            )
            .build();

    public static Response sendPostmanEchoGetRequest(Map<String, Object> queryParams) {
        return given().spec(reqSpec)
                .queryParams(queryParams)
                .when().get("/get")
                .then().extract().response();
    }

    public static Response sendPostmanEchoPostRequest(String body) {
        return given().spec(reqSpec)
                .body(body)
                .when().post("/post")
                .then().extract().response();
    }
}
