package address.capture.entities;

import lombok.Data;

import java.io.Serializable;


/**
 * Class provides a unique primary key for a Province
 */
@Data
public class ProvinceId implements Serializable {

    private String countryCode;

    private String provinceCode;
}
