package api.services;

import api.Model.Human;
import api.assertions.AssertableResponse;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PeopleApiService {
    RequestSpecification requestSpec;
    public final String defaultContentType = "application/json";

    public PeopleApiService(String basePath) {
        this.requestSpec = RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(defaultContentType)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .basePath(basePath);
    }

    public AssertableResponse getPeople() {
        log.info("Get people");
        return new AssertableResponse(requestSpec.when()
                .get("/people/1")
                .then());
    }

    //
    //POST request
    public AssertableResponse postPeople(Human human) {
        log.info("Get people {}", human);
        return new AssertableResponse(requestSpec.when()
                .body(human)
                .when()
                .post("/people/1")
                .then());
    }
}
