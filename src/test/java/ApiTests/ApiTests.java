package ApiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

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
