package address.capture.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProvinceNotFoundException extends RuntimeException {
    private final String countryCode;

    private final String provinceCode;

}
