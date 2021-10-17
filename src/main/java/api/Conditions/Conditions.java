package api.Conditions;

public class Conditions {

    public static StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public static ContentTypeCondition contentType(String type) {
        return new ContentTypeCondition(type);
    }

    public static BodyCondition body(String homeworld, String[] films) {
        return new BodyCondition(homeworld, films);
    }

    public static SchemaCondition schema(String schema) {
        return new SchemaCondition(schema);
    }
}
