package address.capture.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
public class CountryEntity {
    @Id
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "country_name")
    private String countryName;


}
