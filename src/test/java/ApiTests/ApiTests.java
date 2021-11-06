package ApiTests;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTests {

    private Logger logger = Logger.getLogger(getClass());

    private final String endpoint = "https://swapi.dev/api/";
    private final String endpointPeople = "https://swapi.dev/api/people/1";
    private final String endpointPlanets = "https://swapi.dev/api/planets/1";


    @Test
    public static void getResponseBody(){

        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();
    }

    @Test
    public void testPostBin() {
//        Map<String, Object> jsonAsMap = new HashMap<>();
//        jsonAsMap.put("firstName", "John");
//        jsonAsMap.put("lastName", "Doe");

        JSONObject request = new JSONObject();
        request.put("firstName", "John");
        request.put("lastName", "Doe");


        Response list = given()
                //.body(jsonAsMap)
                .body(request)
                .contentType("application/json")
                .when()
                .post("https://httpbin.org/post")
                .then()
                .assertThat().statusCode(200)
                .body("data", equalTo("{\"firstName\":\"John\",\"lastName\":\"Doe\"}"))
                .extract().response().prettyPeek();

    }

    @Test
    public void testAllEndpoints() {
        Response list = given()
                .contentType("application/json")
                .when()
                .get(endpoint)
                .then()
                .assertThat().statusCode(200)
                .extract().response().prettyPeek();
//        logger.info("\n" + list.prettyPrint());
    }

    @Test
    public void testGetNameCharacter() {
        Response list = given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpointPeople)
                .then()
                .assertThat().statusCode(200)
                .extract().response().prettyPeek();

        String name = list.jsonPath().get("name").toString();
        String homeWorld = list.jsonPath().get("homeworld").toString();
        System.out.println("\n" + name + "\n" + homeWorld);
    }

    @Test
    public void test() {
        get(endpointPeople)
                .then().statusCode(200)
                .and()
                .assertThat()
                .body("name", equalTo("Luke Skywalker"))
                .and()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("people1-schema.json"));
    }

    @Test
    public void testGetNamePlanetAndPopulation() {
        Response list = given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpointPlanets)
                .then()
                .assertThat().statusCode(200)
                .extract().response();
        String namePlanet = list.jsonPath().get("name");
        String populationPlanet = list.jsonPath().get("population").toString();
        String nameFilm = list.jsonPath().get("films[1]").toString();
        String residentsName = list.jsonPath().get("residents[4]").toString();
        System.out.println("\n" + namePlanet +
                "\n" + populationPlanet +
                "\n" + nameFilm +
                "\n" + residentsName);
        Assert.assertEquals(namePlanet, "Tatooine");
    }
}
