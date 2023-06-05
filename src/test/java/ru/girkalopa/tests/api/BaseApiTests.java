package ru.girkalopa.tests.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.girkalopa.utils.ResourceUtils;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.girkalopa.steps.api.PostmanApiSteps.sendPostmanEchoGetRequest;
import static ru.girkalopa.steps.api.PostmanApiSteps.sendPostmanEchoPostRequest;

@Epic("Base tests from Girkalo Pavel")
@Feature("Base Api tests for postman echo")
public class BaseApiTests {

    @DisplayName("GET api test")
    @Test
    void getApiTest() {

        Response response = sendPostmanEchoGetRequest(Map.of("foo1", "bar1"));

        assertThat(response.statusCode())
                .as("statusCode must be equal to " + HttpStatus.SC_OK).isEqualTo(HttpStatus.SC_OK);
        assertThat(response.jsonPath().getString("args.foo1"))
                .as("'args' must be equal to bar1").isEqualTo("bar1");
    }

    @DisplayName("POST api test")
    @Test
    void postApiTest() {

        String body = new ResourceUtils().readResourceAsString("json/post.json");
        Response response = sendPostmanEchoPostRequest(body);

        assertThat(response.statusCode())
                .as("statusCode must be equal to " + HttpStatus.SC_OK).isEqualTo(HttpStatus.SC_OK);
        assertThat(response.jsonPath().getString("json.foo1"))
                .as("'json.foo1' must be equal to bar1 ").isEqualTo("bar1");
    }
}
