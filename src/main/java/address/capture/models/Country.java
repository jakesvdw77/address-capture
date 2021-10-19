package address.capture.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {

    private String countryName;

    private String countryCode;
}
