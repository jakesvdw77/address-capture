package address.capture.models;

import lombok.Data;

@Data
public class CustomerAddress
{
    private String line1;

    private String line2;

    private String suburb;

    private String city;

    private int addressId;

    private Province province;

    private Country country;

}
