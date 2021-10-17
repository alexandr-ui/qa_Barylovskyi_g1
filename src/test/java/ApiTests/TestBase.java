package ApiTests;

import api.services.PeopleApiService;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {
    public static PeopleApiService peopleApiService;

    @BeforeClass
    public void setUpServices() {
        RestAssured.baseURI = "https://swapi.dev/api/";
        peopleApiService = new PeopleApiService("/");

    }

}
