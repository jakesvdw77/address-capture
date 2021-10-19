package address.capture.entities;

import javax.persistence.Column;
import javax.persistence.Id;

//@Entity
//@Data
public class Country
{
    @Id
    @Column(name = "country_code")
    private int countryCode;

    private String name;

}
