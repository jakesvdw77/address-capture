package address.capture.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    private String line1;

    private String line2;

    private String suburb;

    private String city;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "province_code", referencedColumnName = "province_code"),
            @JoinColumn(name = "country_code", referencedColumnName = "country_code")
    })
    private ProvinceEntity province;


    @OneToOne
    @JoinColumn(name = "country_code", nullable = false, insertable = false, updatable = false)
    private CountryEntity country;

}
