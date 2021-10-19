package entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProvinceId implements Serializable {

    private int countryCode;

    private int provinceCode;
}
