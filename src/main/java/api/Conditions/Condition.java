package api.Conditions;

import io.restassured.response.ValidatableResponse;

public interface Condition {

    void check(ValidatableResponse  response);
}
