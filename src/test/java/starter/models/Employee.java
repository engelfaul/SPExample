package starter.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "with")
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class Employee {

    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
}
