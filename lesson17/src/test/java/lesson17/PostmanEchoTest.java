package lesson17;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

// здесь не camelCase, потому что в примере в лекции так были описаны методы и мне понравилось
public class PostmanEchoTest {
    static {
        RestAssured.baseURI = "https://postman-echo.com";
    }
    @Test public void test_get_request_status_200() {
        given()
                .when()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test public void test_get_response_time_5000_200() {
        long responseTime =
                given()
                        .when()
                        .get("https://postman-echo.com")
                        .time();

        assert(responseTime<5000);
    }

    @Test
    public void test_get_request_200() {
        given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"));
    }

    @Test
    public void test_post_request_200() {
        given()
                .when()
                .header("Content-Type", "application/json")
                .body("{\"foo1\":\"bar2\"}")
                .post("/post")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_post_multi_part_200() {
        given()
                .multiPart("cat1", "meow1")
                .multiPart("dog2", "bark2")
                .when()
                .post("/post")
                .then()
                .assertThat()
                .statusCode(200)
                .body("form.cat1", equalTo("meow1"))
                .body("form.dog2", equalTo("bark2"));
    }

    @Test
    public void test_put_request() {
        String requestBody = "{\"key\":\"value\"}";

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("json.key", equalTo("value"));
    }
}
