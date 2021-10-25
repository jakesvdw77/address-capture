package address.capture.models;

import lombok.Data;

@Data
public class Address {

    private String line1;

    private String line2;

    private String suburb;

    private String city;

    private String provinceCode;

    private String countryCode;

    private String postalCode;

}
