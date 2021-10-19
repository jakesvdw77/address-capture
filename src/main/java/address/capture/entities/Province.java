package address.capture.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "province")
@Entity
@IdClass(ProvinceId.class)
@NoArgsConstructor
public class Province
{
    public Province(String countryCode, String provinceCode)
    {
        this.countryCode = countryCode;
        this.provinceCode = provinceCode;
    }

    @Id
    @Column(name = "country_code")
    private String countryCode;

    @Id
    @Column(name = "province_code")
    private String provinceCode;

    @Column(name = "province_name")
    private String provinceName;

}
