package address.capture.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "province")
@Entity
@IdClass(ProvinceId.class)
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceEntity
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
