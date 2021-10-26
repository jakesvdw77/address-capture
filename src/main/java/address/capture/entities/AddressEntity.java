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

    @Column(name = "line1" , nullable = false)
    private String line1;

    private String line2;

    private String suburb;

    @Column(name = "city" , nullable = false)
    private String city;


    @Column(name = "postal_code", nullable = false)
    private String postalCode;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "province_code", referencedColumnName = "province_code", nullable = false),
            @JoinColumn(name = "country_code", referencedColumnName = "country_code", nullable = false)
    })
    private ProvinceEntity province;


    @OneToOne
    @JoinColumn(name = "country_code", nullable = false, insertable = false, updatable = false)
    private CountryEntity country;

}
