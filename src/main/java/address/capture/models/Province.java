package address.capture.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Province
{

    private String countryCode;

    private String provinceCode;

    private String provinceName;
}
