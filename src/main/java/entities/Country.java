package entities;

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
    private int countryCode;

    private String name;

}
