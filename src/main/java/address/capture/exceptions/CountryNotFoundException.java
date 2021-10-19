package address.capture.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CountryNotFoundException extends RuntimeException {

    private final String countryCode;

}
