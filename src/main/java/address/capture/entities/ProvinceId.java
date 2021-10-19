package address.capture.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProvinceId implements Serializable {

    private String countryCode;

    private String provinceCode;
}
