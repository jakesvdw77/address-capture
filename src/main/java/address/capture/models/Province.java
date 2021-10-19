package address.capture.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {

    private String countryCode;

    private String provinceCode;

    private String provinceName;
}
