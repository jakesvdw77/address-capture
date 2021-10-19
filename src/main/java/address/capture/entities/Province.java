package address.capture.entities;

import javax.persistence.*;

//@Data
//@Table(name = "province")
//@Entity
//@IdClass(ProvinceId.class)
public class Province
{

    @Id
    @Column(name = "country_code")
    private String countryCode;

    @Id
    @Column(name = "province_code")
    private int provinceCode;

    private String name;

}
