package address.capture.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "province")
@Entity
@IdClass(ProvinceId.class)
public class Province
{

    @Id
    @Column(name = "country_code")
    private String countryCode;

    @Id
    @Column(name = "province_code")
    private String provinceCode;

    @Column(name = "province_name")
    private String provinceName;

}
