package api.Conditions;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ContentTypeCondition implements Condition{

    private String contentType;

    public void check(ValidatableResponse response) {
        response.contentType(contentType);
    }

    @Override
    public String toString() {
        return "content type is " + contentType;
    }
}
