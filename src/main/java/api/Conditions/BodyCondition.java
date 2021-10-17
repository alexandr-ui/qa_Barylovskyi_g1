package api.Conditions;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

@AllArgsConstructor
public class BodyCondition implements Condition {

    private String bodyHomeWorld;
    private String[] bodyFilms;

    public void check(ValidatableResponse response) {
        response.assertThat().body("homeworld", equalTo(bodyHomeWorld))
                .and()
                .assertThat().body("films", hasItems(bodyFilms));
    }
}
