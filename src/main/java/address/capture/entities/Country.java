package address.capture.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Country
{
    @Id
    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

}
