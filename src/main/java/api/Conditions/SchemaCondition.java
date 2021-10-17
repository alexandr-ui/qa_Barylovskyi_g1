package api.Conditions;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@AllArgsConstructor
public class SchemaCondition implements Condition {

    private String schema;

    public void check(ValidatableResponse response) {
        response.assertThat().body(matchesJsonSchemaInClasspath(schema));
    }

    @Override
    public String toString() {
        return "matched schema in " + schema;
    }
}
