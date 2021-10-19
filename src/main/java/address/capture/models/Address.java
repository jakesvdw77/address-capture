package address.capture.models;

import address.capture.entities.Province;
import address.capture.entities.Country;
import lombok.Data;

@Data
public class Address {

    private String line1;

    private String line2;

    private Province province;

    private Country country;

}
