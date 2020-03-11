package org.interview.momenton;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    private static final String API_KEY = "8a93a2f4-a067-4934-bc3e-a76356093544";
    private static final String API_ENDPOINT = "http://api.airvisual.com/v2";

    @Test
    public void TestMissingAPIKey() {
        given().pathParam("countries", "Australia")
                .when().get(API_ENDPOINT + "/states?country={countries}")
                .then().assertThat().statusCode(403);
    }

    @Test
    public void TestValidApiKey() {
        given().queryParam("country", "Australia")
                .queryParam("key", API_KEY)
                .when().get(API_ENDPOINT + "/states")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void TestAllAustraliaStatesAreCorrect() {
        List<String> states = Arrays.asList("New South Wales", "Queensland", "South Australia","Tasmania",
                "Victoria", "Western Australia");

        Response response = given().queryParam("country", "Australia")
                .queryParam("key", API_KEY)
                .when().get(API_ENDPOINT + "/states")
                .then().assertThat().statusCode(200)
                .and().body("status", equalTo("success"))
                .contentType(ContentType.JSON).extract().response();

        List<Object> data = response.jsonPath().getList("data.state");
        assertThat(data.size(), equalTo(6));
        assertThat(data, containsInAnyOrder(states.toArray()));
    }

    @Test
    public void TestNearestCityReturnsCorrectInformation() {
        given().queryParam("key", API_KEY)
                .when().get(API_ENDPOINT + "/nearest_city")
                .then().assertThat().statusCode(200)
                .and().body("status", equalTo("success"));
    }

    @Test
    public void TestNearestCityWithCoordinatesReturnsCorrectInformation() {
        given().queryParam("key", API_KEY).queryParam("lat", "-37.8073959")
                .queryParam("lon", "144.97")
                .when().get(API_ENDPOINT + "/nearest_city")
                .then().assertThat().statusCode(200)
                .and().body("status", equalTo("success"))
                .and().body(matchesJsonSchemaInClasspath("response.json"));
    }
}
