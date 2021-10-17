package ApiTests;

import api.Model.Human;
import api.assertions.AssertableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static api.Conditions.Conditions.*;

public class HumanTests extends TestBase{

    public Human usHuman;

    @Test
    void testGetUserLukeSkywalker() {
        peopleApiService
                .getPeople()
                .shouldHave(statusCode(200))
                .shouldHave(contentType("application/json"))
                .shouldHave(body("https://swapi.dev/api/planets/1/", new String[]{"https://swapi.dev/api/films/1/",
                        "https://swapi.dev/api/films/2/",
                        "https://swapi.dev/api/films/3/"}))
                .shouldHave(schema("people1-schema.json"));
    }

//    @Test
//    void testPostUserLukeSkywalker() {
//        peopleApiService
//                .postPeople(usHuman)
//                .shouldHave(statusCode(200));
//    }

    @Test
    void testGetUserLukeSkywalker_1() {
        AssertableResponse r = peopleApiService.getPeople();
        Assert.assertEquals(r.response.extract().statusCode(),200);
        Assert.assertEquals(r.response.extract().contentType(), "application/json");
//        Assert.assertEquals(peopleApiService.getPeople().response.extract().body()
//                .jsonPath().param("name", "Luke Skywalker").getList("name -> name == name").size(),1);
        List<Map> human = peopleApiService.getPeople()
                .response.extract().body().jsonPath().param("name", "Luke Skywalker").get("name.findAll()");
    }
}
