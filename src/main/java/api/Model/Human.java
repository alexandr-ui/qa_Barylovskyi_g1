package api.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Human {

    @JsonProperty("name")
    public String name;

    @JsonProperty("height")
    public String height;

    @JsonProperty("mass")
    public String mass;

    @JsonProperty("hair_color")
    public String hair_color;

    @JsonProperty("skin_color")
    public String skin_color;

    @JsonProperty("eye_color")
    public String eye_color;

    @JsonProperty("birth_year")
    public String birth_year;

    @JsonProperty("gender")
    public String gender;

    @JsonProperty("homeworld")
    public String homeworld;


}
